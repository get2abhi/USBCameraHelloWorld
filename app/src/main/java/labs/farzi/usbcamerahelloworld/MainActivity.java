package labs.farzi.usbcamerahelloworld;

import android.hardware.usb.UsbDevice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.serenegiant.usb.USBMonitor;
import com.serenegiant.usbcameracommon.*;

public class MainActivity extends AppCompatActivity {
    private String TAG = getClass().getSimpleName();
    /**
     * for accessing USB
     */
    private USBMonitor mUSBMonitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUSBMonitor = new USBMonitor(getApplicationContext(), mOnDeviceConnectListener);
        mUSBMonitor.register();
    }

    @Override
    protected void onDestroy() {
        if (mUSBMonitor != null) {
            mUSBMonitor.destroy();
            mUSBMonitor = null;
        }
        super.onDestroy();
    }

    private final USBMonitor.OnDeviceConnectListener mOnDeviceConnectListener
            = new USBMonitor.OnDeviceConnectListener() {

        @Override
        public void onAttach(final UsbDevice device) {
            Log.v(TAG, "USB_DEVICE_ATTACHED");
            Toast.makeText(MainActivity.this,"USB_DEVICE_ATTACHED", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onConnect(final UsbDevice device,
                              final USBMonitor.UsbControlBlock ctrlBlock, final boolean createNew) {

            Log.v(TAG, "onConnect:");

            //mCameraHandler.open(ctrlBlock);
            //startPreview();
            //updateItems();
        }

        @Override
        public void onDisconnect(final UsbDevice device, final USBMonitor.UsbControlBlock ctrlBlock) {

            Log.v(TAG, "onDisconnect:");
            /*
            if (mCameraHandler != null) {
                queueEvent(new Runnable() {
                    @Override
                    public void run() {
                        stopPreview();
                    }
                }, 0);
                updateItems();
            }
            */
        }
        @Override
        public void onDettach(final UsbDevice device) {
            Log.v(TAG, "USB_DEVICE_DETACHED");
            Toast.makeText(MainActivity.this,"USB_DEVICE_DETACHED", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(final UsbDevice device) {
            //setCameraButton(false);
        }
    };
}
