import { Injectable } from '@angular/core';
import { cordova, IonicNativePlugin } from '@ionic-native/core';

@Injectable()
export class SdkService extends IonicNativePlugin {
    static pluginName = 'weplansdk';
    static plugin = 'cordova-plugin-weplansdk';
    static pluginRef = 'WeplanSdk';
    static platforms = ['Android'];

    enableSdk(): Promise<any> { 
      return cordova(this, 'enableSdk', {}, []);
    }

    disableSdk(): Promise<any> { 
      return cordova(this, 'disableSdk', {}, []);
   }
}