// Generated by view binder compiler. Do not edit!
package com.example.bitseed.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.bitseed.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRegisterBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button buttonRegister;

  @NonNull
  public final EditText editTextEmail;

  @NonNull
  public final EditText editTextPassword;

  @NonNull
  public final EditText editTextPasswordNew;

  @NonNull
  public final ImageView myImageView1;

  @NonNull
  public final RelativeLayout relativeLayoutCenter;

  @NonNull
  public final TextView textViewHeadline;

  @NonNull
  public final TextView textViewLoginNow;

  private ActivityRegisterBinding(@NonNull RelativeLayout rootView, @NonNull Button buttonRegister,
      @NonNull EditText editTextEmail, @NonNull EditText editTextPassword,
      @NonNull EditText editTextPasswordNew, @NonNull ImageView myImageView1,
      @NonNull RelativeLayout relativeLayoutCenter, @NonNull TextView textViewHeadline,
      @NonNull TextView textViewLoginNow) {
    this.rootView = rootView;
    this.buttonRegister = buttonRegister;
    this.editTextEmail = editTextEmail;
    this.editTextPassword = editTextPassword;
    this.editTextPasswordNew = editTextPasswordNew;
    this.myImageView1 = myImageView1;
    this.relativeLayoutCenter = relativeLayoutCenter;
    this.textViewHeadline = textViewHeadline;
    this.textViewLoginNow = textViewLoginNow;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonRegister;
      Button buttonRegister = ViewBindings.findChildViewById(rootView, id);
      if (buttonRegister == null) {
        break missingId;
      }

      id = R.id.editTextEmail;
      EditText editTextEmail = ViewBindings.findChildViewById(rootView, id);
      if (editTextEmail == null) {
        break missingId;
      }

      id = R.id.editTextPassword;
      EditText editTextPassword = ViewBindings.findChildViewById(rootView, id);
      if (editTextPassword == null) {
        break missingId;
      }

      id = R.id.editTextPasswordNew;
      EditText editTextPasswordNew = ViewBindings.findChildViewById(rootView, id);
      if (editTextPasswordNew == null) {
        break missingId;
      }

      id = R.id.myImageView1;
      ImageView myImageView1 = ViewBindings.findChildViewById(rootView, id);
      if (myImageView1 == null) {
        break missingId;
      }

      id = R.id.relativeLayoutCenter;
      RelativeLayout relativeLayoutCenter = ViewBindings.findChildViewById(rootView, id);
      if (relativeLayoutCenter == null) {
        break missingId;
      }

      id = R.id.textViewHeadline;
      TextView textViewHeadline = ViewBindings.findChildViewById(rootView, id);
      if (textViewHeadline == null) {
        break missingId;
      }

      id = R.id.textViewLoginNow;
      TextView textViewLoginNow = ViewBindings.findChildViewById(rootView, id);
      if (textViewLoginNow == null) {
        break missingId;
      }

      return new ActivityRegisterBinding((RelativeLayout) rootView, buttonRegister, editTextEmail,
          editTextPassword, editTextPasswordNew, myImageView1, relativeLayoutCenter,
          textViewHeadline, textViewLoginNow);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}