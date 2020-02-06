package com.example.imusictask.utils.utils_glide;

import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.imusictask.R;

public final class GlideUtils {

    public static void setRoundedCornersImage(ImageView imageView, String imageUrl, int radius) {
        defGlideRequest(imageView, imageUrl, defRequestOpetion().transform(new RoundedCorners(radius)), true);
    }

    public static void setFitCenterImage(ImageView imageView, String imageUrl) {
        defGlideRequest(imageView, imageUrl, defRequestOpetion().transform(new FitCenter()), false);
    }

    public static void setCenterCropedImage(ImageView imageView, String imageUrl) {
        defGlideRequest(imageView, imageUrl, defRequestOpetion().transform(new CenterCrop()), true);
    }

    private static RequestOptions defRequestOpetion() {
        return new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .skipMemoryCache(false);
    }

    private static void defGlideRequest(ImageView imageView, String imageUrl, RequestOptions requestOptions, boolean isWithPlaceHolder) {
        GlideRequest glideRequest = GlideApp.with(imageView.getContext())
                .load(imageUrl)
                .apply(requestOptions);
        if (isWithPlaceHolder) {
            glideRequest = glideRequest.placeholder(R.drawable.ic_launcher_background);
        }

        glideRequest.into(imageView);
    }


}
