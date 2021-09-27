package com.dx.masung_printer;

import android.Manifest;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Environment;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

import java.util.HashMap;
import java.util.Iterator;

import msprintsdk.PrintCmd;
import msprintsdk.UsbDriver;

import static android.content.ContentValues.TAG;

public class DxPrinter {

    public static final String ACTION_USB_PERMISSION = "com.android.dxmasungprinter.USB_PERMISSION";
    public static UsbDriver usbDriver;
    UsbDevice usbDevice = null;

    BroadcastReceiver usbReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (UsbManager.ACTION_USB_DEVICE_DETACHED.equals(action)) {
                UsbDevice device = (UsbDevice) intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
                if ((device.getProductId() == 8211 || device.getProductId() == 8213) && device.getVendorId() == 1305) {
                    usbDriver.closeUsbDevice(device);
                }
            } else if (ACTION_USB_PERMISSION.equals(action)) synchronized (this) {
                UsbDevice device = (UsbDevice) intent.getParcelableExtra(UsbManager.EXTRA_DEVICE);
                if (intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false)) {
                    if ((device.getProductId() == 8211 || device.getProductId() == 8213) && device.getVendorId() == 1305) {
                        //赋权限以后的操作
                    }
                } else {
                    Log.d("error","permission denied for device");
                }
            }

        }
    };

    public int usbDriverCheck(final Context c) {
        int iResult = -1;
        try {
            if (!usbDriver.isUsbPermission()) {
                UsbManager manager = (UsbManager) c.getSystemService(Context.USB_SERVICE);
                HashMap<String, UsbDevice> deviceList = manager.getDeviceList();
                usbDevice = null;
                Iterator<UsbDevice> deviceIterator = deviceList.values().iterator();
                while (deviceIterator.hasNext()) {
                    UsbDevice device = deviceIterator.next();
                    if ((device.getProductId() == 8211 && device.getVendorId() == 1305)
                            || (device.getProductId() == 8213 && device.getVendorId() == 1305)) {
                        usbDevice = device;
                    }
                }
                if (usbDevice != null) {
                    iResult = 1;
                    Log.d("usbDevice:", usbDevice.toString());
                    if (usbDriver.usbAttached(usbDevice)) {
                        if (usbDriver.openUsbDevice(usbDevice))
                            iResult = 0;
                    }
                }
            } else {
                if (!usbDriver.isConnected()) {
                    if (usbDriver.openUsbDevice(usbDevice))
                        iResult = 0;
                } else {
                    iResult = 0;
                }
            }
        } catch (Exception e) {
            Log.d("error", "usbDriverCheck:" + e.getMessage());
        }

        return iResult;
    }

    public String tryUsbDriver(final Context c) {
        try {
            switch(usbDriverCheck(c)) {
                case -1: return "Printer not connected!";
                case 1: return "Printer unauthorized!";
            };
        }
        catch (Exception e) {
            return "tryUsb" +
                    "" +
                    "Driver() uncaught exception " + e.getMessage();
        }

        return "success";
    }

    public void init(final Context c) {
        usbDriver = new UsbDriver((UsbManager) c.getSystemService(Context.USB_SERVICE), c);
        PendingIntent permissionIntent = PendingIntent.getBroadcast(c, 0, new Intent(ACTION_USB_PERMISSION), 0);
        usbDriver.setPermissionIntent(permissionIntent);

        IntentFilter filter = new IntentFilter();
        filter.addAction(UsbManager.ACTION_USB_DEVICE_DETACHED);
        filter.addAction(ACTION_USB_PERMISSION);
        c.registerReceiver(usbReceiver, filter);
    }

    public void SetClean() { usbDriver.write(PrintCmd.SetClean()); };
    public void SetLinespace(int iLinespace) { usbDriver.write(PrintCmd.SetLinespace(iLinespace)); };
    public void SetAlignment(int iAlignment) { usbDriver.write(PrintCmd.SetAlignment(iAlignment)); };
    public void SetBold(int iBold) { usbDriver.write(PrintCmd.SetBold(iBold)); };
    public void SetLeftmargin(int iLeftspace) { usbDriver.write(PrintCmd.SetLeftmargin(iLeftspace)); };
    public void SetRotate(int iRotate) { usbDriver.write(PrintCmd.SetRotate(iRotate)); };
    public void SetDirection(int iDirection) { usbDriver.write(PrintCmd.SetDirection(iDirection)); };
    public void SetWhitemodel(int iWhite) { usbDriver.write(PrintCmd.SetWhitemodel(iWhite)); };
    public void SetCommandmode(int iMode) { usbDriver.write(PrintCmd.SetCommandmode(iMode)); };
    public void SetSpacechar(int iSpace) { usbDriver.write(PrintCmd.SetSpacechar(iSpace)); };
    public void SetMarkoffsetcut(int iOffset) { usbDriver.write(PrintCmd.SetMarkoffsetcut(iOffset)); };
    public void SetMarkoffsetprint(int iOffset) { usbDriver.write(PrintCmd.SetMarkoffsetprint(iOffset)); };
    public void SetSizetext(int iHeight,int iWidth) { usbDriver.write(PrintCmd.SetSizetext(iHeight,iWidth)); };
    public void SetSizechar(int iHeight,int iWidth,int iUnderline,int iAsciitype) { usbDriver.write(PrintCmd.SetSizechar(iHeight,iWidth,iUnderline,iAsciitype)); };
    public void SetItalic(int iItalic) { usbDriver.write(PrintCmd.SetItalic(iItalic)); };

    public void PrintFeedline(int iLine) { usbDriver.write(PrintCmd.PrintFeedline(iLine)); };
    public void PrintString(String strData,int iImme) { usbDriver.write(PrintCmd.PrintString(strData,iImme)); };
    public void PrintCutpaper(int iMode) { usbDriver.write(PrintCmd.PrintCutpaper(iMode)); };
    public void PrintQrcode(String strData,int iLmargin,int iMside,int iRound) { usbDriver.write(PrintCmd.PrintQrcode(strData,iLmargin,iMside,iRound)); };
    public void PrintDiskImagefile(int[] pixels, int iWidth, int iHeight) { usbDriver.write(PrintCmd.PrintDiskImagefile(pixels, iWidth, iHeight)); };
    public void PrintPdf417(int iDotwidth,int iDotheight,int iDatarows,int iDatacolumns,String strData) { usbDriver.write(PrintCmd.PrintPdf417(iDotwidth,iDotheight,iDatarows,iDatacolumns,strData)); };
    public void Print1Dbar(int iWidth,int iHeight,int iHrisize,int iHriseat,int iCodetype,String strData) { usbDriver.write(PrintCmd.Print1Dbar(iWidth,iHeight,iHrisize,iHriseat,iCodetype,strData)); };
    public void PrintMarkposition() { usbDriver.write(PrintCmd.PrintMarkposition()); }
    public void PrintMarkpositioncut() { usbDriver.write(PrintCmd.PrintMarkpositioncut()); }
    public void PrintMarkcutpaper(int iMode) { usbDriver.write(PrintCmd.PrintMarkcutpaper(iMode)); };
    public void PrintNvbmp(int iNvindex,int iMode) { usbDriver.write(PrintCmd.PrintNvbmp(iNvindex,iMode)); };

    public void PrintChargeRow() { usbDriver.write(PrintCmd.PrintChargeRow()); }
    public void PrintFeedDot(int Lnumber) { usbDriver.write(PrintCmd.PrintFeedDot(Lnumber)); };
    public void PrintNextHT() { usbDriver.write(PrintCmd.PrintNextHT()); }
    public void SetUnderline(int underline) { usbDriver.write(PrintCmd.SetUnderline(underline)); };
    public void SetCodepage(int country,int CPnumber) { usbDriver.write(PrintCmd.SetCodepage(country,CPnumber)); };
    public void SetHTseat(byte[] bHTseat,int iLength ) { usbDriver.write(PrintCmd.SetHTseat(bHTseat,iLength )); };

    public Pair<Integer, String> PrintStatus() {
        Integer iResult = 1;
        String strValue = "";
        try {
            int iValue = -1;
            byte[] bRead1 = new byte[1];
            if (usbDriver.read(bRead1, PrintCmd.GetStatus1()) > 0) {
                iValue = PrintCmd.CheckStatus1(bRead1[0]);
                if(iValue!=0)
                    strValue = PrintCmd.getStatusDescriptionEn(iValue);
            }

            if (iValue == 0) {
                iValue = -1;
                if (usbDriver.read(bRead1, PrintCmd.GetStatus2()) > 0) {
                    iValue = PrintCmd.CheckStatus2(bRead1[0]);
                    if(iValue!=0)
                        strValue = PrintCmd.getStatusDescriptionEn(iValue);
                }
            }

            if (iValue == 0) {
                iValue = -1;
                if (usbDriver.read(bRead1, PrintCmd.GetStatus3()) > 0) {
                    iValue = PrintCmd.CheckStatus3(bRead1[0]);
                    if(iValue!=0)
                        strValue = PrintCmd.getStatusDescriptionEn(iValue);
                }
            }
            if (iValue == 0) {
                iValue = -1;
                if (usbDriver.read(bRead1, PrintCmd.GetStatus4()) > 0) {
                    iValue = PrintCmd.CheckStatus4(bRead1[0]);
                    if(iValue!=0)
                        strValue = PrintCmd.getStatusDescriptionEn(iValue);
                }
            }
            if(iValue==0) {
                strValue = PrintCmd.getStatusDescriptionEn(iValue);
            }
            iResult = iValue;
        } catch (Exception e) {
            strValue = e.getMessage();
        }
        return new Pair<Integer, String>(iResult, strValue);
    }

    public Pair<Integer, String> CashboxStatus()
    {
        Integer iResult = -1;
        String strValue = "Cashbox unknown.";
        try {
            byte[] bRead1 = new byte[1];
            byte[] bCmd = new byte[7];
            int iIndex=0;
            bCmd[iIndex++]=0x1B;
            bCmd[iIndex++]=0x72;
            bCmd[iIndex++]=0x01;


            if (usbDriver.read(bRead1, bCmd) > 0)
                if(bRead1[0]==1)
                    strValue = "Cashbox open.";
                else
                    strValue = "Cashbox close.";

        } catch (Exception e) {
            strValue = e.getMessage();
        }
        return new Pair<Integer, String>(iResult, strValue);
    }
}
