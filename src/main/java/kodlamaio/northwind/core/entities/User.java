package kodlamaio.northwind.core.entities;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
  //corea ekleme sebebim her zaman kullanabilirim diğer projelerde de
	//kodda veritabanı oluşturacağız...
@Entity
@Data
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	//pom.xmle paket attık email için
	@Email
	@NotNull  //veri boş olmasın
	@NotBlank
	private String email;
	
	@NotNull  //veri boş olmasın
	@NotBlank
	@Column(name="password")
	private String password;
	
}
