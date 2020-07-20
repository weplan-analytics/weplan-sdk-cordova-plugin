import { Component } from '@angular/core';
import { AndroidPermissions } from '@ionic-native/android-permissions/ngx/';
import { SdkService } from '../sdk.service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  constructor(public sdk: SdkService, private androidPermissions: AndroidPermissions) {}

  requestPermission() {
    this.androidPermissions.checkPermission(this.androidPermissions.PERMISSION.ACCESS_FINE_LOCATION).then(
      result => console.log('Has permission?',result.hasPermission),
      err => this.androidPermissions.requestPermission(this.androidPermissions.PERMISSION.ACCESS_FINE_LOCATION)
    );
    
    this.androidPermissions.requestPermissions([this.androidPermissions.PERMISSION.ACCESS_FINE_LOCATION, this.androidPermissions.PERMISSION.ACCESS_COARSE_LOCATION]);
  }

  enableSdk() {
    this.sdk.enableSdk()
  }

  disableSdk() {
    this.sdk.disableSdk()
  }

}
