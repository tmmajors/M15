package com.company.FinalProject.Crypto;

public class CryptoResponse {

        public String name;
        public String asset_id;
        public double price_usd;

        //getters + setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAsset_id() {
            return asset_id;
        }

        public void setAsset_id(String asset_id) {
            this.asset_id = asset_id;
        }

        public double getPrice_usd() {
            return price_usd;
        }

        public void setPrice_usd(double price_usd) {
            this.price_usd = price_usd;
        }
}
