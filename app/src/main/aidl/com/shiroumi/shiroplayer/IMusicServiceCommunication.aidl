// IMusicServiceCommunication.aidl
package com.shiroumi.shiroplayer;

interface IMusicServiceCommunication {
    void onMusicPlaying(float process);
    void onSeekDone();
    void onMusicChanged();
}