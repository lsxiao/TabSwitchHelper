package com.bangbangarmy.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.bangbangarmy.util.TabSwitchHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabSwitchHelper tabSwitchHelper = new TabSwitchHelper();
        tabSwitchHelper.add(this, R.id.rb_1);
        tabSwitchHelper.add(this, R.id.rb_2);
        tabSwitchHelper.add(this, R.id.rb_3);
        tabSwitchHelper.add(this, R.id.rb_4);
        tabSwitchHelper.checkedFirst();
        tabSwitchHelper.setListener(new TabSwitchHelper.OnTabStateChangedListener() {
            @Override
            public void afterTabStateChanged(CompoundButton button, boolean isChecked) {
                Toast.makeText(MainActivity.this, button.getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean beforeTabStateChanged(CompoundButton button, boolean isChecked) {
                if (button.getId() == R.id.rb_4) {
                    Toast.makeText(MainActivity.this, "event was intercepted", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }
}
