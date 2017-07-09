package myapps.wycoco.com.mynewpokedex.Models;

/**
 * Created by dell on 7/8/2017.
 */

public class ItemModel {

    private String itemName;
    private int itemNumber;
    private String itemEffect;
    private String itemUrl;
    private String imageUrl;

    public ItemModel() {
    }

    public ItemModel(String itemName, int itemNumber, String itemEffect, String imageUrl) {
        this.itemName = itemName;
        this.itemNumber = itemNumber;
        this.itemEffect = itemEffect;
        this.imageUrl = imageUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemNumber() {
        String []urlParties = itemUrl.split("/");
        return Integer.parseInt(urlParties[urlParties.length - 1]);
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemEffect() {
        return itemEffect;
    }

    public void setItemEffect(String itemEffect) {
        this.itemEffect = itemEffect;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
