import { WebPlugin } from '@capacitor/core';

import type { DxPrinterPlugin } from './definitions';

export class DxPrinterWeb extends WebPlugin implements DxPrinterPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
