/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.gouv.faes.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Benucci
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ht.gouv.faes.service.CommuneFacadeREST.class);
        resources.add(ht.gouv.faes.service.ContratFacadeREST.class);
        resources.add(ht.gouv.faes.service.DepartementFacadeREST.class);
        resources.add(ht.gouv.faes.service.DetailsprestationFacadeREST.class);
        resources.add(ht.gouv.faes.service.DistributeurFacadeREST.class);
        resources.add(ht.gouv.faes.service.DonateurFacadeREST.class);
        resources.add(ht.gouv.faes.service.DossierbeneficiaireFacadeREST.class);
        resources.add(ht.gouv.faes.service.EnfantFacadeREST.class);
        resources.add(ht.gouv.faes.service.FichebeneficiaireFacadeREST.class);
        resources.add(ht.gouv.faes.service.FinancerFacadeREST.class);
        resources.add(ht.gouv.faes.service.IndividuFacadeREST.class);
        resources.add(ht.gouv.faes.service.InstitutionFacadeREST.class);
        resources.add(ht.gouv.faes.service.LogFacadeREST.class);
        resources.add(ht.gouv.faes.service.OrganisationFacadeREST.class);
        resources.add(ht.gouv.faes.service.PersonnereferenceFacadeREST.class);
        resources.add(ht.gouv.faes.service.PrestationFacadeREST.class);
        resources.add(ht.gouv.faes.service.ProgrammeFacadeREST.class);
        resources.add(ht.gouv.faes.service.ProjetFacadeREST.class);
        resources.add(ht.gouv.faes.service.RolesFacadeREST.class);
        resources.add(ht.gouv.faes.service.SysdiagramsFacadeREST.class);
        resources.add(ht.gouv.faes.service.TypebeneficiaireFacadeREST.class);
        resources.add(ht.gouv.faes.service.TypeorganistationFacadeREST.class);
        resources.add(ht.gouv.faes.service.TypepocFacadeREST.class);
        resources.add(ht.gouv.faes.service.UtilisateurFacadeREST.class);
    }
    
}
