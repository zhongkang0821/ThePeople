package com.library.ActivityHelp;

import java.util.List;

public interface PermissionListener {
    //全部授权成功
    void onGranted();
    //拒绝了那些权限
    void onDenied(List<String> deniedPermission);
}
