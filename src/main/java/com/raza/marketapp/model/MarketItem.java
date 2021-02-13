package com.raza.marketapp.model;

public class MarketItem {
	int shares;
	double buyprice;
	double sellprice;
	int totalshares;
	public MarketItem(int shares, double buyprice, double sellprice, int totalshares)
	{
		this.shares = shares;
		this.buyprice = buyprice;
		this.sellprice = sellprice;
		this.totalshares = totalshares;
	}
	public int getShares() {
		return this.shares;
	}

	public double getBuyprice() {
		return this.buyprice;
	}

	public double getSellprice() {
		return this.sellprice;
	}

	public double getTotalshares() {
		return this.totalshares;
	}
}
