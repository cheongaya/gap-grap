package com.roovalant.gapgrap.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * The Apt entity
 *
 * @author: DEVROOT
 * @since: 2022.08.20
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "apt")
public class Apt implements Serializable {

}
