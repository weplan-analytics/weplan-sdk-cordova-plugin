
  

# WeplanSDK

A cordova plugin for using weplan's SDK.

***Only supported on Android currently.

  

### Usage with Ionic

  

Wrap plugin with a provider/service:


```
ionic g service sdk
```
Replace the content of the generated file with the following plugin wrap:

    // sdk.service.ts
    
    import { Injectable } from  '@angular/core';
    import { cordova, IonicNativePlugin } from  '@ionic-native/core';
    
      
    
    @Injectable()
    export  class  SdkService  extends  IonicNativePlugin {
	    static  pluginName = 'weplansdk';
	    static  plugin = 'cordova-plugin-weplansdk';
	    static  pluginRef = 'WeplanSdk';
	    static  platforms = ['Android'];
	      
	    enableSdk(clientId: string, clientSecret: string): Promise<any> {
		    return  cordova(this, 'enableSdk', {}, [clientId, clientSecret]);
	    }
	    
	    disableSdk(): Promise<any> {
		    return  cordova(this, 'disableSdk', {}, []);
	    }
    }
  

Now you can use the service anywhere on the project after **including it in the providers in app.module.ts**.

    import { SdkService } from  '../sdk.service';
    
    constructor(private sdk: SdkService) { }
    
    ...
    
    // Usage example
    this.sdk.enableSdk(clientId, clientSecret)
    this.sdk.disable()

**Prerequisite:** ACCESS_FINE_LOCATION must be granted.
