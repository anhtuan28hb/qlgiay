package vn.viettuts.detaiso10.controller;

import vn.viettuts.detaiso10.view.Shopview;

public class Shopcontroller {
    private Shopview shopview;
    public Shopcontroller(Shopview shopview){
        this.shopview=shopview;
        
    }
    public void showShopview(){
        shopview.setVisible(true);
    }
    public void hideShopview(){
        shopview.setVisible(false);
    }
}
