# Weplan SDK Ionic/Cordova Plugin

A cordova plugin to enable/disable Weplan SDK **on Android platform**.

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
            "YOUR_CLIENT_ID",       // Update with your ClientId
            "YOUR_CLIENT_SECRET",   // Update with your ClientSecret
            true                    // This will enable sdk on app updates to those devices with location permission previously granted
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
        weplanSdk.enableSdk(
            "YOUR_CLIENT_ID",       // Update with your ClientId
            "YOUR_CLIENT_SECRET",   // Update with your ClientSecret
            true                    // This will enable sdk on app updates to those devices with location permission previously granted
        )
        //weplanSdk.disable()
    }
```
