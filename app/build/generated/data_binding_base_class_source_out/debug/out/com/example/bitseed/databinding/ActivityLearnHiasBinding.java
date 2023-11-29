// Generated by view binder compiler. Do not edit!
package com.example.bitseed.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.bitseed.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLearnHiasBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayout bottomNavigation;

  @NonNull
  public final LinearLayout cardAnggrek;

  @NonNull
  public final LinearLayout cardBegonia;

  @NonNull
  public final LinearLayout cardLidahMertua;

  @NonNull
  public final LinearLayout hero;

  @NonNull
  public final ImageView homeNav;

  @NonNull
  public final ImageView profileNav;

  @NonNull
  public final ImageView shopNav;

  @NonNull
  public final LinearLayout titleBibit;

  @NonNull
  public final ImageView toLearn;

  private ActivityLearnHiasBinding(@NonNull ConstraintLayout rootView,
      @NonNull LinearLayout bottomNavigation, @NonNull LinearLayout cardAnggrek,
      @NonNull LinearLayout cardBegonia, @NonNull LinearLayout cardLidahMertua,
      @NonNull LinearLayout hero, @NonNull ImageView homeNav, @NonNull ImageView profileNav,
      @NonNull ImageView shopNav, @NonNull LinearLayout titleBibit, @NonNull ImageView toLearn) {
    this.rootView = rootView;
    this.bottomNavigation = bottomNavigation;
    this.cardAnggrek = cardAnggrek;
    this.cardBegonia = cardBegonia;
    this.cardLidahMertua = cardLidahMertua;
    this.hero = hero;
    this.homeNav = homeNav;
    this.profileNav = profileNav;
    this.shopNav = shopNav;
    this.titleBibit = titleBibit;
    this.toLearn = toLearn;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLearnHiasBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLearnHiasBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_learn_hias, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLearnHiasBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottomNavigation;
      LinearLayout bottomNavigation = ViewBindings.findChildViewById(rootView, id);
      if (bottomNavigation == null) {
        break missingId;
      }

      id = R.id.cardAnggrek;
      LinearLayout cardAnggrek = ViewBindings.findChildViewById(rootView, id);
      if (cardAnggrek == null) {
        break missingId;
      }

      id = R.id.cardBegonia;
      LinearLayout cardBegonia = ViewBindings.findChildViewById(rootView, id);
      if (cardBegonia == null) {
        break missingId;
      }

      id = R.id.cardLidahMertua;
      LinearLayout cardLidahMertua = ViewBindings.findChildViewById(rootView, id);
      if (cardLidahMertua == null) {
        break missingId;
      }

      id = R.id.hero;
      LinearLayout hero = ViewBindings.findChildViewById(rootView, id);
      if (hero == null) {
        break missingId;
      }

      id = R.id.home_nav;
      ImageView homeNav = ViewBindings.findChildViewById(rootView, id);
      if (homeNav == null) {
        break missingId;
      }

      id = R.id.profile_nav;
      ImageView profileNav = ViewBindings.findChildViewById(rootView, id);
      if (profileNav == null) {
        break missingId;
      }

      id = R.id.shop_nav;
      ImageView shopNav = ViewBindings.findChildViewById(rootView, id);
      if (shopNav == null) {
        break missingId;
      }

      id = R.id.titleBibit;
      LinearLayout titleBibit = ViewBindings.findChildViewById(rootView, id);
      if (titleBibit == null) {
        break missingId;
      }

      id = R.id.to_learn;
      ImageView toLearn = ViewBindings.findChildViewById(rootView, id);
      if (toLearn == null) {
        break missingId;
      }

      return new ActivityLearnHiasBinding((ConstraintLayout) rootView, bottomNavigation,
          cardAnggrek, cardBegonia, cardLidahMertua, hero, homeNav, profileNav, shopNav, titleBibit,
          toLearn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
