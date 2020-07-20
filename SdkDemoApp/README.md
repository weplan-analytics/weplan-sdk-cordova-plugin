AndroidX required to solve AAPT: error: attribute android:foregroundServiceType not found.

# add plugin to enable AndroidX in the project
cordova plugin add cordova-plugin-androidx

# add plugin to patch existing plugin source that uses the Android Support Library to use AndroidX
cordova plugin add cordova-plugin-androidx-adapter