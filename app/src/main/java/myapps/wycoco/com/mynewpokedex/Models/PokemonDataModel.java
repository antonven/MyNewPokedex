package myapps.wycoco.com.mynewpokedex.Models;

/**
 * Created by dell on 7/6/2017.
 */

public class PokemonDataModel {

    private String pokeNo;
    private String pokeName;
    private String pokeImage;
    private String pokeType;
    private String pokeWeight;
    private String pokeHeight;
    private String pokeVersion;
    private String url;

    public PokemonDataModel(String pokeNo, String pokeName, String pokeImage, String pokeType, String pokeWeight, String pokeHeight, String pokeVersion, String url) {
        this.pokeNo = pokeNo;
        this.pokeName = pokeName;
        this.pokeImage = pokeImage;
        this.pokeType = pokeType;
        this.pokeWeight = pokeWeight;
        this.pokeHeight = pokeHeight;
        this.pokeVersion = pokeVersion;
        this.url = url;
    }

    public PokemonDataModel() {
    }

    public String getPokeNo() {
        return pokeNo;
    }

    public void setPokeNo(String pokeNo) {
        this.pokeNo = pokeNo;
    }

    public String getPokeName() {
        return pokeName;
    }

    public void setPokeName(String pokeName) {
        this.pokeName = pokeName;
    }

    public String getPokeImage() {
        return pokeImage;
    }

    public void setPokeImage(String pokeImage) {
        this.pokeImage = pokeImage;
    }

    public String getPokeType() {
        return pokeType;
    }

    public void setPokeType(String pokeType) {
        this.pokeType = pokeType;
    }

    public String getPokeWeight() {
        return pokeWeight;
    }

    public void setPokeWeight(String pokeWeight) {
        this.pokeWeight = pokeWeight;
    }

    public String getPokeHeight() {
        return pokeHeight;
    }

    public void setPokeHeight(String pokeHeight) {
        this.pokeHeight = pokeHeight;
    }

    public String getPokeVersion() {
        return pokeVersion;
    }

    public void setPokeVersion(String pokeVersion) {
        this.pokeVersion = pokeVersion;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        String[] urlParse = url.split("/");
        return Integer.parseInt(urlParse[urlParse.length - 1]);
    }
}
