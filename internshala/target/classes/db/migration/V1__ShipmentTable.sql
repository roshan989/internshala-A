CREATE TABLE payload(
    loadingPoint varchar(15),
	unloadingPoint varchar(15),
	productType varchar(15),
	truckType varchar(15),
	noOfTrucks int,
	weight int,
    comment varchar(25),
	shipperId UUID NOT NULL PRIMARY KEY,
	Date date
    );