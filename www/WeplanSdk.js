var exec = require('cordova/exec');

module.exports.enableSdk = function(arg0, arg1, arg2, success, error) {
    exec(success, error, 'WeplanSdk', 'enableSdk', [arg0, arg1, arg2])
};

module.exports.disableSdk = function(success, error) {
    exec(success, error, 'WeplanSdk', 'disableSdk')
};