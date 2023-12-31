// Generated by view binder compiler. Do not edit!
package com.example.bitseed.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.bitseed.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityTomatBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayout heading;

  @NonNull
  public final TextView kategori;

  @NonNull
  public final TextView lahan;

  @NonNull
  public final TextView nama;

  @NonNull
  public final TextView penanaman;

  @NonNull
  public final TextView persiapan;

  private ActivityTomatBinding(@NonNull ConstraintLayout rootView, @NonNull LinearLayout heading,
      @NonNull TextView kategori, @NonNull TextView lahan, @NonNull TextView nama,
      @NonNull TextView penanaman, @NonNull TextView persiapan) {
    this.rootView = rootView;
    this.heading = heading;
    this.kategori = kategori;
    this.lahan = lahan;
    this.nama = nama;
    this.penanaman = penanaman;
    this.persiapan = persiapan;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTomatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTomatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_tomat, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTomatBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.heading;
      LinearLayout heading = ViewBindings.findChildViewById(rootView, id);
      if (heading == null) {
        break missingId;
      }

      id = R.id.kategori;
      TextView kategori = ViewBindings.findChildViewById(rootView, id);
      if (kategori == null) {
        break missingId;
      }

      id = R.id.lahan;
      TextView lahan = ViewBindings.findChildViewById(rootView, id);
      if (lahan == null) {
        break missingId;
      }

      id = R.id.nama;
      TextView nama = ViewBindings.findChildViewById(rootView, id);
      if (nama == null) {
        break missingId;
      }

      id = R.id.penanaman;
      TextView penanaman = ViewBindings.findChildViewById(rootView, id);
      if (penanaman == null) {
        break missingId;
      }

      id = R.id.persiapan;
      TextView persiapan = ViewBindings.findChildViewById(rootView, id);
      if (persiapan == null) {
        break missingId;
      }

      return new ActivityTomatBinding((ConstraintLayout) rootView, heading, kategori, lahan, nama,
          penanaman, persiapan);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
