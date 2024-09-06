package com.flutterjunction.property_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import android.animation.AnimatorInflater;
import android.animation.Animator;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;


//Property animation allows you to animate properties of an object over a certain duration.
// You can animate various properties such as translation, rotation, scale, and alpha.

/* view animation is the traditional animation framework that allows you to animate
 views by applying transformations directly to the view. It operates on the View object itself
 and provides simple animations like fading, scaling, translating, and rotating.
 But not background color
 */


public class MainActivity extends AppCompatActivity {
    private Button animateButton;
    private View targetView;


    //    for drawable animation
    private ImageView animationImageView;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animateButton = findViewById(R.id.animate_button);
        targetView = findViewById(R.id.target_view);


//        for drawable animation
//        animationImageView = findViewById(R.id.animation_image_view);
//        animationDrawable = (AnimationDrawable) getResources().getDrawable(R.drawable.animation_drawable);
//        animationImageView.setImageDrawable(animationDrawable);

        animateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Property Animation*/

                //              tranlation allows  you to animate the movement of a view along the X and Y axes.
//                ObjectAnimator animator = ObjectAnimator.ofFloat(targetView, "translationX", 0f, 50f);

//                 the alpha property is commonly used to animate the transparency or opacity of a view.
//                ObjectAnimator animator = ObjectAnimator.ofFloat(targetView, "alpha", 1f, 0.5f);

//              Rotation animation in Android allows you to animate the rotation of a view around a pivot point.
//                ObjectAnimator animator = ObjectAnimator.ofFloat(targetView, "rotation", 0f, 360f);
//
//                set the time for animation
//                animator.setDuration(1000);
//                start animation
//                animator.start();

                /*Property Animation*/

                /*View animation*/
                Animation fadeInAnimation = new AlphaAnimation(0f, 1f);
                fadeInAnimation.setDuration(1000);
                targetView.startAnimation(fadeInAnimation);

                /*View animation*/

                /*For drawable animation*/
//                animationDrawable.start();
            }
        });
    }
}