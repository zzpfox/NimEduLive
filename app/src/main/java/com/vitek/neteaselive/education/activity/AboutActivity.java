package com.vitek.neteaselive.education.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.vitek.neteaselive.BuildConfig;
import com.vitek.neteaselive.NimCache;
import com.vitek.neteaselive.R;
import com.vitek.neteaselive.base.ui.TActivity;


/**
 * Created by hzxuwen on 2016/3/10.
 */
public class AboutActivity extends TActivity {
    private TextView versionGit;
    private TextView versionDate;
    private TextView accountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.actionbar_logo_white);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.actionbar_white_back_icon);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViews();
        initViewData();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void findViews() {
        versionGit = (TextView) findViewById(R.id.version_detail_git);
        versionDate = (TextView) findViewById(R.id.version_detail_date);
        accountText = (TextView) findViewById(R.id.account);
    }

    private void initViewData() {
        // 如果使用的IDE是Eclipse， 将该函数体注释掉。这里使用了Android Studio编译期添加BuildConfig字段的特性
        versionGit.setText("Git Version: " + BuildConfig.GIT_REVISION);
        versionDate.setText("Build Date:" + BuildConfig.BUILD_DATE);
        accountText.setText("account:" + NimCache.getAccount());
    }
}
