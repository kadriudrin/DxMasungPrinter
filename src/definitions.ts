export interface DxPrinterPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
