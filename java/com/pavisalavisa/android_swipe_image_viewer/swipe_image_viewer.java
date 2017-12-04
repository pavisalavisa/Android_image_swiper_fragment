package com.pavisalavisa.android_swipe_image_viewer;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.Console;


/**
 * A simple {@link Fragment} subclass.
 */
public class swipe_image_viewer extends Fragment {

    private int[] imagesIDToDisplay;

    public swipe_image_viewer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewPager viewPager=(ViewPager)getView().findViewById(R.id.view_pager);
        ImagePagerAdapter adapter=new ImagePagerAdapter();
        viewPager.setAdapter(adapter);
        return inflater.inflate(R.layout.fragment_swipe_image_viewer, container, false);
    }


    private class ImagePagerAdapter extends PagerAdapter {

        @Override
        public int getCount()
        {
            return imagesIDToDisplay.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object)
        {
            return view==((ImageView)object);
        }
        @Override
        public Object instantiateItem(ViewGroup container,int position)
        {
            Context context=getView().getContext();
            ImageView imageView=new ImageView(context);
            int padding=context.getResources().getDimensionPixelSize(R.dimen.padding_medium);
            imageView.setPadding(padding,padding,padding,padding);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setImageResource(imagesIDToDisplay[position]);
            ((ViewPager)container).addView(imageView,0);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object)
        {
            ((ViewPager)container).removeView((ImageView)object);
        }



    }

    public void setImagesIDToDisplay(int [] imagesIDToDisplay) throws NullPointerException
    {
        if (imagesIDToDisplay==null){
            throw new NullPointerException();
        }
        else{
           this.imagesIDToDisplay=imagesIDToDisplay;
        }
    }

}
