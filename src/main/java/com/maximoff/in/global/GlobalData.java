package com.maximoff.in.global;

import com.maximoff.in.model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {

    public static List<Product> cart;
    static {
        cart=new ArrayList<>();
    }
}
