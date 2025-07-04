
package acme.realms.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import acme.client.components.basis.AbstractRole;
import acme.client.components.mappings.Automapped;
import acme.client.components.validation.Mandatory;
import acme.client.components.validation.Optional;
import acme.client.components.validation.ValidNumber;
import acme.client.components.validation.ValidString;
import acme.constraints.ValidCustomer;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@ValidCustomer
@Table(indexes = {
	@Index(columnList = "identifier", unique = true)
})
public class Customer extends AbstractRole {

	// Serialisation version -----------------------------------------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	// Attributes ----------------------------------------------------------------------------------------------------

	@Mandatory
	@ValidString(pattern = "^[A-Z]{2,3}\\d{6}$")
	@Column(unique = true)
	private String				identifier;

	@Mandatory
	@ValidString(pattern = "^\\+?\\d{6,15}$")
	@Automapped
	private String				phoneNumber;

	@Mandatory
	@ValidString(min = 1, max = 255)
	@Automapped
	private String				physicalAddress;

	@Mandatory
	@ValidString(min = 1, max = 50)
	@Automapped
	private String				city;

	@Mandatory
	@ValidString(min = 1, max = 50)
	@Automapped
	private String				country;

	@Optional
	@ValidNumber(min = 0, max = 500000)
	@Automapped
	private Integer				earnedPoints;

}
