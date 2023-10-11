package readers;

import org.aeonbits.owner.Config;

@Config.LoadPolicy( Config.LoadType.MERGE )
@Config.Sources( {
		"classpath:datapool/account.properties",
		"classpath:datapool/cfna.properties",
		"classpath:datapool/fsd.properties",
		"classpath:datapool/records.properties",
		"classpath:datapool/vehicles.properties"
} )
public interface DataPoolConfig extends Config {

	@Config.Key( "account.name" )
	String accountName ( );

	@Config.Key( "account.lastName" )
	String accountLastName ( );

	@Config.Key( "account.address1" )
	String accountAddress1 ( );

	@Config.Key( "account.address2" )
	String accountAddress2 ( );

	@Config.Key( "account.creditCardNumber" )
	String accountCreditCardNumber ( );

	@Config.Key( "account.nameHolder" )
	String accountNameHolder ( );

	@Config.Key( "account.expirationDate" )
	String accountExpirationDate ( );

	@Config.Key( "account.securityCode" )
	String accountSecurityCode ( );

	@Config.Key( "cfna.username" )
	String cfnaUsername ( );

	@Config.Key( "cfna.password" )
	String cfnaPassword ( );

	@Config.Key( "cfna.question1" )
	String cfnaQuestion1 ( );

	@Config.Key( "cfna.answer1" )
	String cfnaAnswer1 ( );

	@Config.Key( "cfna.question2" )
	String cfnaQuestion2 ( );

	@Config.Key( "cfna.answer2" )
	String cfnaAnswer2 ( );

	@Config.Key( "cfna.question3" )
	String cfnaQuestion3 ( );

	@Config.Key( "cfna.answer3" )
	String cfnaAnswer3 ( );

	@Config.Key( "fsd.validZip" )
	String fsdValidZip ( );

	@Config.Key( "fsd.invalidZip" )
	String fsdInvalidZip ( );

	@Config.Key( "fsd.address" )
	String fsdAddress ( );

	@Config.Key( "fsd.city" )
	String fsdCity ( );

	@Config.Key( "fsd.state" )
	String fsdState ( );

	@Config.Key( "record.servicedBy" )
	String recordServicedBy ( );

	@Config.Key( "record.price" )
	String recordPrice ( );

	@Config.Key( "record.serviceType" )
	String recordServiceType ( );

	@Config.Key( "record.description" )
	String recordDescription ( );

	@Config.Key( "record.invoiceNumber" )
	String recordInvoiceNumber ( );

	@Config.Key( "record.storeNumber" )
	String recordStoreNumber ( );

	@Config.Key( "record.validPhone" )
	String recordValidPhone ( );

	@Config.Key( "record.invalidPhone" )
	String recordInvalidPhone ( );

	@Config.Key( "record.invalidInvoiceNumber" )
	String recordInvalidInvoiceNumber ( );

	@Config.Key( "record.invalidStoreNumber" )
	String recordInvalidStoreNumber ( );

	@Config.Key( "vehicle1.year" )
	String vehicle1Year ( );

	@Config.Key( "vehicle1.make" )
	String vehicle1Make ( );

	@Config.Key( "vehicle1.model" )
	String vehicle1Model ( );

	@Config.Key( "vehicle1.subModel" )
	String vehicle1SubModel ( );

	@Config.Key( "vehicle1.drivingConditions" )
	String vehicle1DrivingConditions ( );

	@Config.Key( "vehicle1.name" )
	String vehicle1Name ( );

	@Config.Key( "vehicle1.mileage" )
	String vehicle1Mileage ( );

	@Config.Key( "vehicle1.engine" )
	String vehicle1Engine ( );

	@Config.Key( "vehicle1.editName" )
	String vehicle1EditName ( );

	@Config.Key( "vehicle1.editMileage" )
	String vehicle1EditMileage ( );

	@Config.Key( "vehicle1.editTpms" )
	String vehicle1EditTpms ( );

	@Config.Key( "vehicle1.editDrivingConditions" )
	String vehicle1EditDrivingConditions ( );

	@Config.Key( "vehicle2.year" )
	String vehicle2Year ( );

	@Config.Key( "vehicle2.make" )
	String vehicle2Make ( );

	@Config.Key( "vehicle2.model" )
	String vehicle2Model ( );

	@Config.Key( "vehicle2.subModel" )
	String vehicle2SubModel ( );

	@Config.Key( "vehicle2.drivingConditions" )
	String vehicle2DrivingConditions ( );

	@Config.Key( "vehicle2.name" )
	String vehicle2Name ( );

	@Config.Key( "vehicle2.mileage" )
	String vehicle2Mileage ( );

	@Config.Key( "vehicle3.year" )
	String vehicle3Year ( );

	@Config.Key( "vehicle3.make" )
	String vehicle3Make ( );

	@Config.Key( "vehicle3.model" )
	String vehicle3Model ( );

	@Config.Key( "vehicle3.subModel" )
	String vehicle3SubModel ( );

	@Config.Key( "vehicle3.drivingConditions" )
	String vehicle3DrivingConditions ( );

	@Config.Key( "vehicle3.name" )
	String vehicle3Name ( );

	@Config.Key( "vehicle3.mileage" )
	String vehicle3Mileage ( );

	@Config.Key( "vehicle3.engine" )
	String vehicle3Engine ( );

	@Config.Key( "vehicle4.year" )
	String vehicle4Year ( );

	@Config.Key( "vehicle4.make" )
	String vehicle4Make ( );

	@Config.Key( "vehicle4.model" )
	String vehicle4Model ( );

	@Config.Key( "vehicle4.subModel" )
	String vehicle4SubModel ( );

	@Config.Key( "vehicle4.drivingConditions" )
	String vehicle4DrivingConditions ( );

	@Config.Key( "vehicle4.name" )
	String vehicle4Name ( );

	@Config.Key( "vehicle4.mileage" )
	String vehicle4Mileage ( );

	@Config.Key( "vehicle5.year" )
	String vehicle5Year ( );

	@Config.Key( "vehicle5.make" )
	String vehicle5Make ( );

	@Config.Key( "vehicle5.model" )
	String vehicle5Model ( );

	@Config.Key( "vehicle5.subModel" )
	String vehicle5SubModel ( );

	@Config.Key( "vehicle5.drivingConditions" )
	String vehicle5DrivingConditions ( );

	@Config.Key( "vehicle5.name" )
	String vehicle5Name ( );

	@Config.Key( "vehicle5.mileage" )
	String vehicle5Mileage ( );

	@Config.Key( "vehicle6.year" )
	String vehicle6Year ( );

	@Config.Key( "vehicle6.make" )
	String vehicle6Make ( );

	@Config.Key( "vehicle6.model" )
	String vehicle6Model ( );

	@Config.Key( "vehicle6.subModel" )
	String vehicle6SubModel ( );

	@Config.Key( "vehicle6.drivingConditions" )
	String vehicle6DrivingConditions ( );

	@Config.Key( "vehicle6.name" )
	String vehicle6Name ( );

	@Config.Key( "vehicle6.mileage" )
	String vehicle6Mileage ( );

	@Config.Key( "vehicle6.tire1" )
	String vehicle6Tire1 ( );

	@Config.Key( "vehicle6.tire2" )
	String vehicle6Tire2 ( );

	@Config.Key( "vehicle6.engine1" )
	String vehicle6Engine1 ( );

	@Config.Key( "vehicle6.engine2" )
	String vehicle6Engine2 ( );

	@Config.Key( "vehicle7.year" )
	String vehicle7Year ( );

	@Config.Key( "vehicle7.make" )
	String vehicle7Make ( );

	@Config.Key( "vehicle7.model" )
	String vehicle7Model ( );

	@Config.Key( "vehicle7.subModel" )
	String vehicle7SubModel ( );

	@Config.Key( "vehicle7.drivingConditions" )
	String vehicle7DrivingConditions ( );

	@Config.Key( "vehicle7.name" )
	String vehicle7Name ( );

	@Config.Key( "vehicle7.mileage" )
	String vehicle7Mileage ( );

	@Config.Key( "vehicle8.year" )
	String vehicle8Year ( );

	@Config.Key( "vehicle8.make" )
	String vehicle8Make ( );

	@Config.Key( "vehicle8.model" )
	String vehicle8Model ( );

	@Config.Key( "vehicle8.subModel" )
	String vehicle8SubModel ( );

	@Config.Key( "vehicle8.drivingConditions" )
	String vehicle8DrivingConditions ( );

	@Config.Key( "vehicle8.name" )
	String vehicle8Name ( );

	@Config.Key( "vehicle8.mileage" )
	String vehicle8Mileage ( );

	@Config.Key( "store.withReviewsZip" )
	String storeWithReviewsZip ( );

	@Config.Key( "store.withReviewsFullZip" )
	String storeWithReviewsFullZip ( );

	@Config.Key( "store.withReviewsCity" )
	String storeWithReviewsCity ( );

	@Config.Key( "store.withReviewsState" )
	String storeWithReviewsState ( );

	@Config.Key( "store.withReviewsName" )
	String storeWithReviewsName ( );

	@Config.Key( "store.withReviewsNumber" )
	String storeWithReviewsNumber ( );

	@Config.Key( "store.withoutReviewsFullZip" )
	String storeWithoutReviewsFullZip ( );

	@Config.Key( "store.withoutReviewsName" )
	String storeWithoutReviewsName ( );

	@Config.Key( "store.withoutReviewsNumber" )
	String storeWithoutReviewsNumber ( );

	@Config.Key( "user.email" )
	String userEmail ( );

	@Config.Key( "user.password" )
	String userPassword ( );

	@Config.Key( "user.phoneNumber" )
	String userPhoneNumber ( );

	@Config.Key( "user.current" )
	String userCurrent ( );

	@Config.Key( "user.new" )
	String userNew ( );

	@Config.Key( "user.current.password" )
	String userCurrentPassword ( );

	@Config.Key( "user.new.password" )
	String userNewPassword ( );

	@Config.Key( "user.deletion" )
	String userDeletion ( );

	@Config.Key( "user.deletion.password" )
	String userDeletionPassword ( );

	@Config.Key( "user.creation" )
	String userCreation ( );

	@Config.Key( "user.creation.password" )
	String userCreationPassword ( );

	@Config.Key( "user.verification" )
	String userVerification ( );

	@Config.Key( "user.verification.password" )
	String userVerificationPassword ( );

	@Config.Key( "user.invalid" )
	String userInvalid ( );

	@Config.Key( "user.invalid.password" )
	String userInvalidPassword ( );

	@Config.Key( "user.lock" )
	String userLock ( );

	@Config.Key( "user.lock.password" )
	String userLockPassword ( );

	@Config.Key( "user.change" )
	String userChange ( );

	@Config.Key( "user.change.current.password" )
	String userChangeCurrentPassword ( );

	@Config.Key( "user.change.new.password" )
	String userChangeNewPassword ( );

}
