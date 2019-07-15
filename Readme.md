# Android Service Demo
播放一段在 res/raw 的噪声音频

1. 主Activity中采用 new Intent + startService 的方式启动service
2. service中保存播放器，播放声音，暂停+结束
3. service绑定到activity上