package com.ashish.runtimemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int MENU_DOWNLOAD = 1;
    private final int MENU_SETTINGS = 2;
    private boolean showDownloadMenu = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //handle click
    public void toggleMenu(View view) {
        showDownloadMenu=!showDownloadMenu;
    }
    //Android calls onCreateOptionsMenu() to create the menu.
    //Here is the code to dynamically build the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_DOWNLOAD, 0, "Download");
        menu.add(0, MENU_SETTINGS, 0, "Setting");
        return true;
    }
    //For best programming practice, don't use onCreateOptionsMenu()
    //to update or change your menu; instead, use onPrepareOptionsMenu()
    //Here is the code to change the visibility of the Download menu item based on our flag
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.findItem(MENU_DOWNLOAD);
        menuItem.setVisible(showDownloadMenu);
        return true;
    }
    //onOptionsItemSelected() code shows how to respond to each menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_DOWNLOAD:
                Toast.makeText(this, "Click download",
                        Toast.LENGTH_LONG).show();
                break;
            case MENU_SETTINGS:
                Toast.makeText(this, "Click Setting",
                        Toast.LENGTH_LONG).show();
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }
}