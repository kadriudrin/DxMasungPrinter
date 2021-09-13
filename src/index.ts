import { registerPlugin } from '@capacitor/core';

import type { DxPrinterPlugin } from './definitions';

const DxPrinter = registerPlugin<DxPrinterPlugin>('DxPrinter', {
  web: () => import('./web').then(m => new m.DxPrinterWeb()),
});

export * from './definitions';
export { DxPrinter };
