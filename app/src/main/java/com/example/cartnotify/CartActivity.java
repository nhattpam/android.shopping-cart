package com.example.cartnotify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        TextView cartTitle = findViewById(R.id.cartTitle);
        LinearLayout cartItemsLayout = findViewById(R.id.cartItemsLayout);

        List<Product> cartItems = getIntent().getParcelableArrayListExtra("cartItems");
        displayCartItems(cartItems, cartItemsLayout);
    }

    private void displayCartItems(List<Product> cartItems, LinearLayout cartItemsLayout) {
        for (Product product : cartItems) {
            TextView itemTextView = new TextView(this);
            ImageView imageView = new ImageView(this);
            itemTextView.setText(product.getName());
            imageView.setImageResource(product.getImage());
            cartItemsLayout.addView(itemTextView);
            cartItemsLayout.addView(imageView);
        }
    }
}