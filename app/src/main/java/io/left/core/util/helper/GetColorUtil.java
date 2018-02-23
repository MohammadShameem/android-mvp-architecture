package io.left.core.util.helper;


import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;

public class GetColorUtil {


    public static int PalletColorFromImage(Bitmap bitmap){
        try {
            if (bitmap != null) {

                Palette palette = Palette.from(bitmap).generate();


                int colorVibrant = palette.getVibrantColor(0x000000);
                if (colorVibrant!=0){
                    return  colorVibrant;
                }

                int colorDarkVibrant = palette.getDarkVibrantColor(0x000000);
                if (colorDarkVibrant!=0){
                    return  colorDarkVibrant;
                }

                int colorLightMuted = palette.getLightMutedColor(0x000000);
                if (colorLightMuted!=0){
                    return  colorLightMuted;
                }
                int colorMutedColor = palette.getMutedColor(0x000000);
                if (colorMutedColor!=0){
                    return  colorMutedColor;
                }

                int colorDarkMuted = palette.getDarkMutedColor(0x000000);
                if (colorDarkMuted!=0){
                    return  colorDarkMuted;
                }

                int colorLightVibrant = palette.getLightVibrantColor(0x000000);
                if (colorLightVibrant!=0){
                    return  colorLightVibrant;
                }
                return 0;

            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;

        }
    }
}
