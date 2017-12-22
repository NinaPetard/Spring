/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.gtm.nina.springfull.dao;

import fr.gtm.nina.springfull.domaine.Employe;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author adminl
 */
public interface EmployeDao extends JpaRepository<Employe,Long>{
    //List<Employe> findbyNom(String nom);
}
