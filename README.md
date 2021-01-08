# WeplanSDK

A cordova plugin for using Weplan SDK **on Android platform**.

### Usage with Apache/Cordova

Add plugin to cordova project

```
cordova plugin add https://github.com/weplan-analytics/weplan-sdk-cordova-plugin.git
```

Use after deviceready event, calling the plugin as follow:

```
    // Enable SDK
    cordova.exec(
        function(winParam) {},
        function(error) {},
        "WeplanSdk",
        "enableSdk",
        [
            "fGthbeJ9tru8CDlQUqhKmLXDxwXWzQLxfSjwEeoJ1iWTS9dLNRfIF295LEFwV3dGx53FhY2Oj9m1SDWDoeDhcA", // ClientId
            "Youbgyj54SbfMjMcFSCWjAzSDKk8GzJc2VP7DTqWR8LhuqNhb29rOfDOb9GNS0FUhMFtBiKlNqmXVCjMjk3U8u", // ClientSecret
            true    // Enable on Startup
        ]
    );

    // Disable SDK
    cordova.exec(
        function(winParam) {},
        function(error) {},
        "WeplanSdk",
        "disableSdk",
        []
    );
```



### Usage with Ionic

Add cordova plugin

´´´
ionic cordova plugin add https://github.com/weplan-analytics/weplan-sdk-cordova-plugin.git
´´´

Wrap cordova plugin creating a new provider/service:

```
ionic g service weplanSdk
```

Replace the content of the generated file (**weplan-sdk.service.ts**) with the following plugin wrap:

```
    // weplan-sdk.service.ts
    
    import { Injectable } from  '@angular/core';
    import { cordova, IonicNativePlugin } from  '@ionic-native/core';
    
    @Injectable()
    export  class  WeplanSdkService  extends  IonicNativePlugin {
	    static  pluginName = 'weplansdk';
	    static  plugin = 'cordova-plugin-weplansdk';
	    static  pluginRef = 'WeplanSdk';
	    static  platforms = ['Android'];
	      
	    enableSdk(clientId: string, clientSecret: string, startOnUpdate: boolean): Promise<any> {
		    return  cordova(this, 'enableSdk', {}, [clientId, clientSecret, startOnUpdate]);
	    }
	    
	    disableSdk(): Promise<any> {
		    return  cordova(this, 'disableSdk', {}, []);
	    }
    }
```

**Include the service on the project as provider in app.module.ts**

Now you can use the service anywhere on the project

```
    import { WeplanSdkService } from  '../weplan-sdk.service';
    
    constructor(private weplanSdk: WeplanSdkService) { 
        weplanSdk.enableSdk(clientId, clientSecret, true)
        //weplanSdk.disable()
    }
```
