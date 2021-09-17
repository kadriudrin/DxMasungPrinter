import { WebPlugin } from '@capacitor/core';

import type { DxPrinterPlugin } from './definitions';

export class DxPrinterWeb extends WebPlugin implements DxPrinterPlugin {
  CheckPrinter(): Promise<string> {
    return new Promise(() => '');
  }

  SetClean(): void {
    return;
  }
  SetLinespace(options: { iLinespace: number }): void {
    return;
  }
  SetAlignment(options: { iAlignment: number }): void {
    return;
  }
  SetBold(options: { iBold: number }): void {
    return;
  }
  SetLeftmargin(options: { iLeftspace: number }): void {
    return;
  }
  SetRotate(options: { iRotate: number }): void {
    return;
  }
  SetDirection(options: { iDirection: number }): void {
    return;
  }
  SetWhitemodel(options: { iWhite: number }): void {
    return;
  }
  SetCommandmode(options: { iMode: number }): void {
    return;
  }
  SetSpacechar(options: { iSpace: number }): void {
    return;
  }
  SetMarkoffsetcut(options: { iOffset: number }): void {
    return;
  }
  SetMarkoffsetprint(options: { iOffset: number }): void {
    return;
  }
  SetSizetext(options: { iHeight: number; iWidth: number }): void {
    return;
  }
  SetSizechar(options: {
    iHeight: number;
    iWidth: number;
    iUnderline: number;
    iAsciitype: number;
  }): void {
    return;
  }
  SetItalic(options: { iItalic: number }): void {
    return;
  }
  PrintFeedline(options: { iLine: number }): void {
    return;
  }
  PrintString(options: { strData: string; iImme: number }): void {
    return;
  }
  PrintCutpaper(options: { iMode: number }): void {
    return;
  }
  PrintQrcode(options: {
    strData: string;
    iLmargin: number;
    iMside: number;
    iRound: number;
  }): void {
    return;
  }
  PrintDiskImagefile(options: { strData: string }): void {
    return;
  }
  PrintPdf417(options: {
    iDotwidth: number;
    iDotheight: number;
    iDatarows: number;
    iDatacolumns: number;
    strData: string;
  }): void {
    return;
  }
  Print1Dbar(options: {
    iWidth: number;
    iHeight: number;
    iHrisize: number;
    iHriseat: number;
    iCodetype: number;
    strData: string;
  }): void {
    return;
  }
  PrintMarkposition(): void {
    return;
  }
  PrintMarkpositioncut(): void {
    return;
  }
  PrintMarkcutpaper(options: { iMode: number }): void {
    return;
  }
  PrintNvbmp(options: { iNvindex: number; iMode: number }): void {
    return;
  }

  GetStatus(): number {
    return -1;
  }
  PrintChargeRow(): void {
    return;
  }
  PrintFeedDot(options: { Lnumber: number }): void {
    return;
  }
  PrintNextHT(): void {
    return;
  }
  SetUnderline(options: { underline: number }): void {
    return;
  }
  SetCodepage(options: { country: number; CPnumber: number }): void {
    return;
  }
  SetHTseat(options: { numberbHTseat: number[]; iLength: number }): void {
    return;
  }
}
