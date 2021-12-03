package com.gulukal.PhoneBook.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

	private StringProperty name;
	private StringProperty surname;
	private StringProperty phoneNumber;
	private StringProperty address;
	private StringProperty city;
	private StringProperty country;
	private IntegerProperty postalCode;
	private ObjectProperty<LocalDate> birthday;

	public Person() {   // property tip kullandiggimiz icin bu sekilde ilk deger atiyoruz
		
		
		this.name= new SimpleStringProperty();
		this.surname= new SimpleStringProperty();
		this.phoneNumber= new SimpleStringProperty();
		this.address= new SimpleStringProperty();
		this.city= new SimpleStringProperty();
		this.country= new SimpleStringProperty();
		this.postalCode= new SimpleIntegerProperty();
		this.birthday= new SimpleObjectProperty<LocalDate>();

	}

	public Person(Builder builder) {
		
		this();
		this.name.set(builder.name);
		this.surname.set(builder.surname);
		this.phoneNumber.set(builder.phoneNumber);
		this.address.set(builder.address);
		this.city.set(builder.city);
		this.country.set(builder.country);
		this.postalCode.set(builder.postalCode);
		this.birthday.set(builder.birthday);

	}

	public Person(String name, String surname) {

		this();
		this.name.set(name);
		this.surname.set(surname);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", surname=" + surname + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", city=" + city + ", country=" + country + ", postalCode=" + postalCode + ", birthday=" + birthday
				+ "]";
	}

	public static class Builder { // ic sinif inner class public static

		private String name;
		private String surname;
		private String phoneNumber;
		private String address;
		private String city;
		private String country;
		private int postalCode;
		private LocalDate birthday;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder surname(String surname) {
			this.surname = surname;
			return this;
		}

		public Builder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Builder city(String city) {
			this.city = city;
			return this;
		}

		public Builder country(String country) {
			this.country = country;
			return this;
		}

		public Builder postalCode(int postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		public Builder birthday(LocalDate birthday) {
			this.birthday = birthday;
			return this;
		}

		public Person build() { // bu class i al
			return new Person(this);
		}

	}
}