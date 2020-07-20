var exec = require('cordova/exec');

module.exports.enableSdk = function(success, error) {
    exec(success, error, 'WeplanSdk', 'enableSdk')
};

module.exports.disableSdk = function(success, error) {
    exec(success, error, 'WeplanSdk', 'disableSdk')
};