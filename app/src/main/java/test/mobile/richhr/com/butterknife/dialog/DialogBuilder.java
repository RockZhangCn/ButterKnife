package test.mobile.richhr.com.butterknife.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by moon.zhong on 2015/2/26.
 */
public class DialogBuilder extends AlertDialog.Builder {

    private Context mContext ;
    private AlertDialog mAlertDialog ;
    public DialogBuilder(Context context) {
        super(context);
        mContext = context ;
    }

    public DialogBuilder(Context context, int theme) {
        super(context, theme);
        mContext = context ;
    }

    @NonNull
    @Override
    public AlertDialog show() {
        mAlertDialog = super.show() ;
        mAlertDialog.getButton(AlertDialog.BUTTON_POSITIVE) ;
        final int titleId = mContext.getResources().getIdentifier("alertTitle","id","android") ;
        TextView titleTxt = (TextView) mAlertDialog.findViewById(titleId);
        titleTxt.setTextColor(0xff45c01a);
//
        final int topPanel = mContext.getResources().getIdentifier("topPanel","id","android") ;
        LinearLayout topPanelLayout = (LinearLayout) mAlertDialog.findViewById(topPanel);
        topPanelLayout.setVisibility(View.VISIBLE);
//
        final int titleDivider = mContext.getResources().getIdentifier("titleDivider","id","android") ;
        View titleDividerImg =  mAlertDialog.findViewById(titleDivider);
        titleDividerImg.setVisibility(View.VISIBLE);
        titleDividerImg.setBackgroundColor(0xff45c01a);
//
//        final int buttonPanel = mContext.getResources().getIdentifier("buttonPanel","id","android") ;
//        LinearLayout buttonPanelLayout = (LinearLayout) mAlertDialog.findViewById(buttonPanel);
//        buttonPanelLayout.setVisibility(View.GONE);
        final int contentPanel = mContext.getResources().getIdentifier("contentPanel","id","android") ;
        LinearLayout contentPanelLayout = (LinearLayout) mAlertDialog.findViewById(contentPanel);
        contentPanelLayout.setVisibility(View.VISIBLE);

        final int message = mContext.getResources().getIdentifier("message","id","android") ;
        TextView messageTextView = (TextView) mAlertDialog.findViewById(message);
        messageTextView.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,20,mContext.getResources().getDisplayMetrics()));
        messageTextView.setPadding(20,20,20,20);
        messageTextView.setVisibility(View.VISIBLE);

        final int button1 = mContext.getResources().getIdentifier("button1","id","android") ;
        Button negativeButton = (Button) mAlertDialog.findViewById(button1);
        negativeButton.setBackgroundResource(R.drawable.button_selector);
        negativeButton.setVisibility(View.VISIBLE);
        negativeButton.setTextColor(0xff45c01a);
        final int button2 = mContext.getResources().getIdentifier("button2","id","android") ;
        Button positiveButton = (Button) mAlertDialog.findViewById(button2);
        positiveButton.setBackgroundResource(R.drawable.button_selector);
        positiveButton.setVisibility(View.VISIBLE);
        positiveButton.setTextColor(0xff45c01a);
        return mAlertDialog;
    }

    /*    <?xml version="1.0" encoding="utf-8"?>
    <!--
*//* //device/apps/common/res/layout/alert_dialog.xml
**
** Copyright 2006, The Android Open Source Project
**
** Licensed under the Apache License, Version 2.0 (the "License");
** you may not use this file except in compliance with the License.
** You may obtain a copy of the License at
**
**     http://www.apache.org/licenses/LICENSE-2.0
**
** Unless required by applicable law or agreed to in writing, software
** distributed under the License is distributed on an "AS IS" BASIS,
** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
** See the License for the specific language governing permissions and
** limitations under the License.
*//*
            -->

    <LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/parentPanel"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:paddingTop="9dip"
    android:paddingBottom="3dip"
    android:paddingStart="3dip"
    android:paddingEnd="1dip">

    <LinearLayout android:id="@+id/topPanel"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:minHeight="54dip"
    android:orientation="vertical">
    <LinearLayout android:id="@+id/title_template"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:gravity="center_vertical"
    android:layout_marginTop="6dip"
    android:layout_marginBottom="9dip"
    android:layout_marginStart="10dip"
    android:layout_marginEnd="10dip">
    <ImageView android:id="@+id/icon"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_gravity="top"
    android:paddingTop="6dip"
    android:paddingEnd="10dip"
    android:src="@drawable/ic_dialog_info" />
    <com.android.internal.widget.DialogTitle android:id="@+id/alertTitle"
    style="?android:attr/textAppearanceLarge"
    android:singleLine="true"
    android:ellipsize="end"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:textAlignment="viewStart" />
    </LinearLayout>
    <ImageView android:id="@+id/titleDivider"
    android:layout_width="match_parent"
    android:layout_height="1dip"
    android:visibility="gone"
    android:scaleType="fitXY"
    android:gravity="fill_horizontal"
    android:src="@android:drawable/divider_horizontal_dark" />
    <!-- If the client uses a customTitle, it will be added here. -->
    </LinearLayout>

    <LinearLayout android:id="@+id/contentPanel"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_weight="1"
    android:orientation="vertical">
    <ScrollView android:id="@+id/scrollView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:paddingTop="2dip"
    android:paddingBottom="12dip"
    android:paddingStart="14dip"
    android:paddingEnd="10dip"
    android:overScrollMode="ifContentScrolls">
    <TextView android:id="@+id/message"
    style="?android:attr/textAppearanceMedium"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="5dip" />
    </ScrollView>
    </LinearLayout>

    <FrameLayout android:id="@+id/customPanel"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_weight="1">
    <FrameLayout android:id="@+android:id/custom"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:paddingTop="5dip"
    android:paddingBottom="5dip" />
    </FrameLayout>

    <LinearLayout android:id="@+id/buttonPanel"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:minHeight="54dip"
    android:orientation="vertical" >
    <LinearLayout
    style="?android:attr/buttonBarStyle"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:paddingTop="4dip"
    android:paddingStart="2dip"
    android:paddingEnd="2dip"
    android:measureWithLargestChild="true">
    <LinearLayout android:id="@+id/leftSpacer"
    android:layout_weight="0.25"
    android:layout_width="0dip"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:visibility="gone" />
    <Button android:id="@+id/button1"
    android:layout_width="0dip"
    android:layout_gravity="start"
    android:layout_weight="1"
    style="?android:attr/buttonBarButtonStyle"
    android:maxLines="2"
    android:layout_height="wrap_content" />
    <Button android:id="@+id/button3"
    android:layout_width="0dip"
    android:layout_gravity="center_horizontal"
    android:layout_weight="1"
    style="?android:attr/buttonBarButtonStyle"
    android:maxLines="2"
    android:layout_height="wrap_content" />
    <Button android:id="@+id/button2"
    android:layout_width="0dip"
    android:layout_gravity="end"
    android:layout_weight="1"
    style="?android:attr/buttonBarButtonStyle"
    android:maxLines="2"
    android:layout_height="wrap_content" />
    <LinearLayout android:id="@+id/rightSpacer"
    android:layout_width="0dip"
    android:layout_weight="0.25"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:visibility="gone" />
    </LinearLayout>
    </LinearLayout>
    </LinearLayout>*/
}
