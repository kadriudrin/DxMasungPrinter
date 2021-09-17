package com.dx.masung_printer;

import android.Manifest;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import static msprintsdk.UtilsTools.convertToBlackWhite;

@CapacitorPlugin(name = "DxPrinter",
        permissions = {
            @Permission(strings = { DxPrinter.ACTION_USB_PERMISSION }, alias = "usb")
        }
)
public class DxPrinterPlugin extends Plugin {

    private DxPrinter implementation = new DxPrinter();

    public void load(){
        implementation.init(getContext());
    }

    @PluginMethod
    public void CheckPrinter(PluginCall call) {
        String ret = implementation.tryUsbDriver(getContext());
        if (ret == "success") call.resolve();
        else call.reject(ret);
    }

    @PluginMethod
    public void SetClean(PluginCall call) { 
        implementation.SetClean();
        call.resolve();
    };
    @PluginMethod
    public void SetLinespace(PluginCall call) { 
        implementation.SetLinespace(call.getInt("iLinespace"));
        call.resolve();
    };
    @PluginMethod
    public void SetAlignment(PluginCall call) { 
        implementation.SetAlignment(call.getInt("iAlignment"));
        call.resolve();
    };
    @PluginMethod
    public void SetBold(PluginCall call) { 
        implementation.SetBold(call.getInt("iBold"));
        call.resolve();
    };
    @PluginMethod
    public void SetLeftmargin(PluginCall call) { 
        implementation.SetLeftmargin(call.getInt("iLeftspace"));
        call.resolve();
    };
    @PluginMethod
    public void SetRotate(PluginCall call) { 
        implementation.SetRotate(call.getInt("iRotate"));
        call.resolve();
    };
    @PluginMethod
    public void SetDirection(PluginCall call) { 
        implementation.SetDirection(call.getInt("iDirection"));
        call.resolve();
    };
    @PluginMethod
    public void SetWhitemodel(PluginCall call) { 
        implementation.SetWhitemodel(call.getInt("iWhite"));
        call.resolve();
    };
    @PluginMethod
    public void SetCommandmode(PluginCall call) { 
        implementation.SetCommandmode(call.getInt("iMode"));
        call.resolve();
    };
    @PluginMethod
    public void SetSpacechar(PluginCall call) { 
        implementation.SetSpacechar(call.getInt("iSpace"));
        call.resolve();
    };
    @PluginMethod
    public void SetMarkoffsetcut(PluginCall call) { 
        implementation.SetMarkoffsetcut(call.getInt("iOffset"));
        call.resolve();
    };
    @PluginMethod
    public void SetMarkoffsetprint(PluginCall call) { 
        implementation.SetMarkoffsetprint(call.getInt("iOffset"));
        call.resolve();
    };
    @PluginMethod
    public void SetSizetext(PluginCall call) { 
        implementation.SetSizetext(call.getInt("iHeight"), call.getInt("iWidth"));
        call.resolve();
    };
    @PluginMethod
    public void SetSizechar(PluginCall call) { 
        implementation.SetSizechar(call.getInt("iHeight"), call.getInt("iWidth"), call.getInt("iUnderline"), call.getInt("iAsciitype"));
        call.resolve();
    };
    @PluginMethod
    public void SetItalic(PluginCall call) { 
        implementation.SetItalic(call.getInt("iItalic"));
        call.resolve();
    };
    @PluginMethod

    public void PrintFeedline(PluginCall call) { 
        implementation.PrintFeedline(call.getInt("iLine"));
        call.resolve();
    };
    @PluginMethod
    public void PrintString(PluginCall call) { 
        implementation.PrintString(call.getString("strData"), call.getInt("iImme"));
        call.resolve();
    };
    @PluginMethod
    public void PrintCutpaper(PluginCall call) { 
        implementation.PrintCutpaper(call.getInt("iMode"));
        call.resolve();
    };
    @PluginMethod
    public void PrintQrcode(PluginCall call) { 
        implementation.PrintQrcode(call.getString("strData"), call.getInt("iLmargin"), call.getInt("iMside"), call.getInt("iRound"));
        call.resolve();
    };
    @PluginMethod
    public void PrintDiskImagefile(PluginCall call) {
        Bitmap bitmap = null;
        try {
            byte[] bytes = Base64.decode(call.getString("strData").split(",")[1], Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            bitmap = convertToBlackWhite(bitmap);
            int width = bitmap.getWidth();
            int heigh = bitmap.getHeight();
            int iDataLen = width * heigh;
            int[] pixels = new int[iDataLen];
            bitmap.getPixels(pixels, 0, width, 0, 0, width, heigh);
            int[] data1 = pixels;
            implementation.PrintDiskImagefile(pixels, width, heigh);
            call.resolve();
        } catch (Exception e) {
            call.reject("Image print error: ", e.getMessage());
        }
    };
    @PluginMethod
    public void PrintPdf417(PluginCall call) { 
        implementation.PrintPdf417(call.getInt("iDotwidth"), call.getInt("iDotheight"), call.getInt("iDatarows"), call.getInt("iDatacolumns"), call.getString("strData"));
        call.resolve();
    };
    @PluginMethod
    public void Print1Dbar(PluginCall call) { 
        implementation.Print1Dbar(call.getInt("iWidth"), call.getInt("iHeight"), call.getInt("iHrisize"), call.getInt("iHriseat"), call.getInt("iCodetype"), call.getString("strData"));
        call.resolve();
    };
    @PluginMethod
    public void PrintMarkposition(PluginCall call) { 
        implementation.PrintMarkposition();
        call.resolve();
    }
    @PluginMethod
    public void PrintMarkpositioncut(PluginCall call) { 
        implementation.PrintMarkpositioncut();
        call.resolve();
    }
    @PluginMethod
    public void PrintMarkcutpaper(PluginCall call) { 
        implementation.PrintMarkcutpaper(call.getInt("iMode"));
        call.resolve();
    };
    @PluginMethod
    public void PrintNvbmp(PluginCall call) { 
        implementation.PrintNvbmp(call.getInt("iNvindex"), call.getInt("iMode"));
        call.resolve();
    };
    @PluginMethod

    public void GetStatus(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("status", implementation.GetStatus());
        call.resolve(ret);
    }
    @PluginMethod
    public void PrintChargeRow(PluginCall call) { 
        implementation.PrintChargeRow();
        call.resolve();
    }
    @PluginMethod
    public void PrintFeedDot(PluginCall call) { 
        implementation.PrintFeedDot(call.getInt("Lnumber"));
        call.resolve();
    };
    @PluginMethod
    public void PrintNextHT(PluginCall call) { 
        implementation.PrintNextHT();
        call.resolve();
    }
    @PluginMethod
    public void SetUnderline(PluginCall call) { 
        implementation.SetUnderline(call.getInt("underline"));
        call.resolve();
    };
    @PluginMethod
    public void SetCodepage(PluginCall call) { 
        implementation.SetCodepage(call.getInt("country"), call.getInt("CPnumber"));
        call.resolve();
    };
    @PluginMethod
    public void SetHTseat(PluginCall call) {
        JSArray src = call.getArray("bHTseat");
        if (src == null) {
            return;
        }

        byte[] arr = new byte[src.length()];

        try {
            for (int i = 0; i < src.length(); i++)
                arr[i] = (byte)src.get(i);
            implementation.SetHTseat(arr, call.getInt("iLength"));
            call.resolve();
        }
        catch (Exception e) {
            call.reject("Cannot process array type");
        }
    };
}