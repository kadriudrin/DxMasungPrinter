export interface DxPrinterPlugin {
  CheckPrinter(): Promise<string>;
  SetClean(): void;
  SetLinespace(options: { iLinespace: number }): void;
  SetAlignment(options: { iAlignment: number }): void;
  SetBold(options: { iBold: number }): void;
  SetLeftmargin(options: { iLeftspace: number }): void;
  SetRotate(options: { iRotate: number }): void;
  SetDirection(options: { iDirection: number }): void;
  SetWhitemodel(options: { iWhite: number }): void;
  SetCommandmode(options: { iMode: number }): void;
  SetSpacechar(options: { iSpace: number }): void;
  SetMarkoffsetcut(options: { iOffset: number }): void;
  SetMarkoffsetprint(options: { iOffset: number }): void;
  SetSizetext(options: { iHeight: number; iWidth: number }): void;
  SetSizechar(options: {
    iHeight: number;
    iWidth: number;
    iUnderline: number;
    iAsciitype: number;
  }): void;
  SetItalic(options: { iItalic: number }): void;
  PrintFeedline(options: { iLine: number }): void;
  PrintString(options: { strData: string; iImme: number }): void;
  PrintCutpaper(options: { iMode: number }): void;
  PrintQrcode(options: {
    strData: string;
    iLmargin: number;
    iMside: number;
    iRound: number;
  }): void;
  PrintDiskImagefile(options: { strData: string }): void;
  PrintPdf417(options: {
    iDotwidth: number;
    iDotheight: number;
    iDatarows: number;
    iDatacolumns: number;
    strData: string;
  }): void;
  Print1Dbar(options: {
    iWidth: number;
    iHeight: number;
    iHrisize: number;
    iHriseat: number;
    iCodetype: number;
    strData: string;
  }): void;
  PrintMarkposition(): void;
  PrintMarkpositioncut(): void;
  PrintMarkcutpaper(options: { iMode: number }): void;
  PrintNvbmp(options: { iNvindex: number; iMode: number }): void;

  GetStatus(): number;
  PrintChargeRow(): void;
  PrintFeedDot(options: { Lnumber: number }): void;
  PrintNextHT(): void;
  SetUnderline(options: { underline: number }): void;
  SetCodepage(options: { country: number; CPnumber: number }): void;
  SetHTseat(options: { numberbHTseat: number[]; iLength: number }): void;
}
