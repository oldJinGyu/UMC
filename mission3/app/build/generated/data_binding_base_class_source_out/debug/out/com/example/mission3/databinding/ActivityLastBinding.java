// Generated by view binder compiler. Do not edit!
package com.example.mission3.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.mission3.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLastBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnFragment1;

  @NonNull
  public final Button btnFragment2;

  @NonNull
  public final Button button3;

  @NonNull
  public final FrameLayout frameFragment;

  @NonNull
  public final LinearLayout linearLayout2;

  private ActivityLastBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnFragment1,
      @NonNull Button btnFragment2, @NonNull Button button3, @NonNull FrameLayout frameFragment,
      @NonNull LinearLayout linearLayout2) {
    this.rootView = rootView;
    this.btnFragment1 = btnFragment1;
    this.btnFragment2 = btnFragment2;
    this.button3 = button3;
    this.frameFragment = frameFragment;
    this.linearLayout2 = linearLayout2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLastBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLastBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_last, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLastBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_fragment1;
      Button btnFragment1 = ViewBindings.findChildViewById(rootView, id);
      if (btnFragment1 == null) {
        break missingId;
      }

      id = R.id.btn_fragment2;
      Button btnFragment2 = ViewBindings.findChildViewById(rootView, id);
      if (btnFragment2 == null) {
        break missingId;
      }

      id = R.id.button3;
      Button button3 = ViewBindings.findChildViewById(rootView, id);
      if (button3 == null) {
        break missingId;
      }

      id = R.id.frame_fragment;
      FrameLayout frameFragment = ViewBindings.findChildViewById(rootView, id);
      if (frameFragment == null) {
        break missingId;
      }

      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      return new ActivityLastBinding((ConstraintLayout) rootView, btnFragment1, btnFragment2,
          button3, frameFragment, linearLayout2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
