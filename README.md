# dx-masung-printer

Capacitor plugin which allows the use of masung printers

## Install

```bash
npm install dx-masung-printer
npx cap sync
```

## API

<docgen-index>

* [`CheckPrinter()`](#checkprinter)
* [`SetClean()`](#setclean)
* [`SetLinespace(...)`](#setlinespace)
* [`SetAlignment(...)`](#setalignment)
* [`SetBold(...)`](#setbold)
* [`SetLeftmargin(...)`](#setleftmargin)
* [`SetRotate(...)`](#setrotate)
* [`SetDirection(...)`](#setdirection)
* [`SetWhitemodel(...)`](#setwhitemodel)
* [`SetCommandmode(...)`](#setcommandmode)
* [`SetSpacechar(...)`](#setspacechar)
* [`SetMarkoffsetcut(...)`](#setmarkoffsetcut)
* [`SetMarkoffsetprint(...)`](#setmarkoffsetprint)
* [`SetSizetext(...)`](#setsizetext)
* [`SetSizechar(...)`](#setsizechar)
* [`SetItalic(...)`](#setitalic)
* [`PrintFeedline(...)`](#printfeedline)
* [`PrintString(...)`](#printstring)
* [`PrintCutpaper(...)`](#printcutpaper)
* [`PrintQrcode(...)`](#printqrcode)
* [`PrintDiskImagefile(...)`](#printdiskimagefile)
* [`PrintPdf417(...)`](#printpdf417)
* [`Print1Dbar(...)`](#print1dbar)
* [`PrintMarkposition()`](#printmarkposition)
* [`PrintMarkpositioncut()`](#printmarkpositioncut)
* [`PrintMarkcutpaper(...)`](#printmarkcutpaper)
* [`PrintNvbmp(...)`](#printnvbmp)
* [`PrintChargeRow()`](#printchargerow)
* [`PrintFeedDot(...)`](#printfeeddot)
* [`PrintNextHT()`](#printnextht)
* [`SetUnderline(...)`](#setunderline)
* [`SetCodepage(...)`](#setcodepage)
* [`SetHTseat(...)`](#sethtseat)
* [`PrintStatus()`](#printstatus)
* [`CashboxStatus()`](#cashboxstatus)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### CheckPrinter()

```typescript
CheckPrinter() => any
```

**Returns:** <code>any</code>

--------------------


### SetClean()

```typescript
SetClean() => void
```

--------------------


### SetLinespace(...)

```typescript
SetLinespace(options: { iLinespace: number; }) => void
```

| Param         | Type                                 |
| ------------- | ------------------------------------ |
| **`options`** | <code>{ iLinespace: number; }</code> |

--------------------


### SetAlignment(...)

```typescript
SetAlignment(options: { iAlignment: number; }) => void
```

| Param         | Type                                 |
| ------------- | ------------------------------------ |
| **`options`** | <code>{ iAlignment: number; }</code> |

--------------------


### SetBold(...)

```typescript
SetBold(options: { iBold: number; }) => void
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ iBold: number; }</code> |

--------------------


### SetLeftmargin(...)

```typescript
SetLeftmargin(options: { iLeftspace: number; }) => void
```

| Param         | Type                                 |
| ------------- | ------------------------------------ |
| **`options`** | <code>{ iLeftspace: number; }</code> |

--------------------


### SetRotate(...)

```typescript
SetRotate(options: { iRotate: number; }) => void
```

| Param         | Type                              |
| ------------- | --------------------------------- |
| **`options`** | <code>{ iRotate: number; }</code> |

--------------------


### SetDirection(...)

```typescript
SetDirection(options: { iDirection: number; }) => void
```

| Param         | Type                                 |
| ------------- | ------------------------------------ |
| **`options`** | <code>{ iDirection: number; }</code> |

--------------------


### SetWhitemodel(...)

```typescript
SetWhitemodel(options: { iWhite: number; }) => void
```

| Param         | Type                             |
| ------------- | -------------------------------- |
| **`options`** | <code>{ iWhite: number; }</code> |

--------------------


### SetCommandmode(...)

```typescript
SetCommandmode(options: { iMode: number; }) => void
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ iMode: number; }</code> |

--------------------


### SetSpacechar(...)

```typescript
SetSpacechar(options: { iSpace: number; }) => void
```

| Param         | Type                             |
| ------------- | -------------------------------- |
| **`options`** | <code>{ iSpace: number; }</code> |

--------------------


### SetMarkoffsetcut(...)

```typescript
SetMarkoffsetcut(options: { iOffset: number; }) => void
```

| Param         | Type                              |
| ------------- | --------------------------------- |
| **`options`** | <code>{ iOffset: number; }</code> |

--------------------


### SetMarkoffsetprint(...)

```typescript
SetMarkoffsetprint(options: { iOffset: number; }) => void
```

| Param         | Type                              |
| ------------- | --------------------------------- |
| **`options`** | <code>{ iOffset: number; }</code> |

--------------------


### SetSizetext(...)

```typescript
SetSizetext(options: { iHeight: number; iWidth: number; }) => void
```

| Param         | Type                                              |
| ------------- | ------------------------------------------------- |
| **`options`** | <code>{ iHeight: number; iWidth: number; }</code> |

--------------------


### SetSizechar(...)

```typescript
SetSizechar(options: { iHeight: number; iWidth: number; iUnderline: number; iAsciitype: number; }) => void
```

| Param         | Type                                                                                      |
| ------------- | ----------------------------------------------------------------------------------------- |
| **`options`** | <code>{ iHeight: number; iWidth: number; iUnderline: number; iAsciitype: number; }</code> |

--------------------


### SetItalic(...)

```typescript
SetItalic(options: { iItalic: number; }) => void
```

| Param         | Type                              |
| ------------- | --------------------------------- |
| **`options`** | <code>{ iItalic: number; }</code> |

--------------------


### PrintFeedline(...)

```typescript
PrintFeedline(options: { iLine: number; }) => void
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ iLine: number; }</code> |

--------------------


### PrintString(...)

```typescript
PrintString(options: { strData: string; iImme: number; }) => void
```

| Param         | Type                                             |
| ------------- | ------------------------------------------------ |
| **`options`** | <code>{ strData: string; iImme: number; }</code> |

--------------------


### PrintCutpaper(...)

```typescript
PrintCutpaper(options: { iMode: number; }) => void
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ iMode: number; }</code> |

--------------------


### PrintQrcode(...)

```typescript
PrintQrcode(options: { strData: string; iLmargin: number; iMside: number; iRound: number; }) => void
```

| Param         | Type                                                                                |
| ------------- | ----------------------------------------------------------------------------------- |
| **`options`** | <code>{ strData: string; iLmargin: number; iMside: number; iRound: number; }</code> |

--------------------


### PrintDiskImagefile(...)

```typescript
PrintDiskImagefile(options: { strData: string; }) => void
```

| Param         | Type                              |
| ------------- | --------------------------------- |
| **`options`** | <code>{ strData: string; }</code> |

--------------------


### PrintPdf417(...)

```typescript
PrintPdf417(options: { iDotwidth: number; iDotheight: number; iDatarows: number; iDatacolumns: number; strData: string; }) => void
```

| Param         | Type                                                                                                              |
| ------------- | ----------------------------------------------------------------------------------------------------------------- |
| **`options`** | <code>{ iDotwidth: number; iDotheight: number; iDatarows: number; iDatacolumns: number; strData: string; }</code> |

--------------------


### Print1Dbar(...)

```typescript
Print1Dbar(options: { iWidth: number; iHeight: number; iHrisize: number; iHriseat: number; iCodetype: number; strData: string; }) => void
```

| Param         | Type                                                                                                                      |
| ------------- | ------------------------------------------------------------------------------------------------------------------------- |
| **`options`** | <code>{ iWidth: number; iHeight: number; iHrisize: number; iHriseat: number; iCodetype: number; strData: string; }</code> |

--------------------


### PrintMarkposition()

```typescript
PrintMarkposition() => void
```

--------------------


### PrintMarkpositioncut()

```typescript
PrintMarkpositioncut() => void
```

--------------------


### PrintMarkcutpaper(...)

```typescript
PrintMarkcutpaper(options: { iMode: number; }) => void
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ iMode: number; }</code> |

--------------------


### PrintNvbmp(...)

```typescript
PrintNvbmp(options: { iNvindex: number; iMode: number; }) => void
```

| Param         | Type                                              |
| ------------- | ------------------------------------------------- |
| **`options`** | <code>{ iNvindex: number; iMode: number; }</code> |

--------------------


### PrintChargeRow()

```typescript
PrintChargeRow() => void
```

--------------------


### PrintFeedDot(...)

```typescript
PrintFeedDot(options: { Lnumber: number; }) => void
```

| Param         | Type                              |
| ------------- | --------------------------------- |
| **`options`** | <code>{ Lnumber: number; }</code> |

--------------------


### PrintNextHT()

```typescript
PrintNextHT() => void
```

--------------------


### SetUnderline(...)

```typescript
SetUnderline(options: { underline: number; }) => void
```

| Param         | Type                                |
| ------------- | ----------------------------------- |
| **`options`** | <code>{ underline: number; }</code> |

--------------------


### SetCodepage(...)

```typescript
SetCodepage(options: { country: number; CPnumber: number; }) => void
```

| Param         | Type                                                |
| ------------- | --------------------------------------------------- |
| **`options`** | <code>{ country: number; CPnumber: number; }</code> |

--------------------


### SetHTseat(...)

```typescript
SetHTseat(options: { numberbHTseat: number[]; iLength: number; }) => void
```

| Param         | Type                                                 |
| ------------- | ---------------------------------------------------- |
| **`options`** | <code>{ numberbHTseat: {}; iLength: number; }</code> |

--------------------


### PrintStatus()

```typescript
PrintStatus() => any
```

**Returns:** <code>any</code>

--------------------


### CashboxStatus()

```typescript
CashboxStatus() => any
```

**Returns:** <code>any</code>

--------------------

</docgen-api>
