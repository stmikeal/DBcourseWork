package com.example.dbcoursework.controller;

import com.example.dbcoursework.entity.Claim;
import com.example.dbcoursework.entity.local.*;
import com.example.dbcoursework.repository.ClaimRepository;
import com.example.dbcoursework.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/proxy")
public class ProxyController {

    private final PersonService personService;
    private final SecureService secureService;
    private final OrganizationService organizationService;
    private final RoleService roleService;
    private final ClaimService claimService;
    private final ClaimRepository claimRepository;

    @GetMapping("/registered")
    public ResponseEntity<String> isPersonRegistered(@RequestParam("name") String name,
                                                     @RequestParam("id") Long id) {
        return personService.checkPersonByName(name, id)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/register")
    @ResponseBody
    public BasicEntity registerPerson(@RequestBody PersonSecure personSecure) {
        BasicEntity response = null;
        if (secureService.checkAuthorization(personSecure.getSecure())) {
            if (!personService.checkPersonByName(
                    personSecure.getPerson().getName(), personSecure.getPerson().getId())) {
                response = personService
                        .registerPerson(personSecure.getPerson(), personSecure.getOrganizations(), personSecure.getRoles())
                        .map(id -> new BasicEntity(id, personSecure.getPerson().getName()))
                        .orElse(null);
            }
        }
        return response;
    }

    @PostMapping("/org")
    public ResponseEntity<String> appendOrganization(@RequestBody SecureDescriptionEntity secureDescriptionEntity){
        if (secureService.checkAuthorization(secureDescriptionEntity.getSecure())) {
            return organizationService.registerOrganization(secureDescriptionEntity.getEntity())
                    ? new ResponseEntity<>(HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/role")
    public ResponseEntity<String> appendRole(@RequestBody SecureDescriptionEntity secureDescriptionEntity){
        if (secureService.checkAuthorization(secureDescriptionEntity.getSecure())) {
            return roleService.registerRole(secureDescriptionEntity.getEntity())
                    ? new ResponseEntity<>(HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/claim")
    public ResponseEntity<String> createClaim(@RequestBody SecureClaimEntity secureClaimEntity) {
        if (secureService.checkAuthorization(secureClaimEntity.getSecure())) {
            return claimService.createClaim(secureClaimEntity.getClaim(), secureClaimEntity.getSecure().getLogin())
                    ? new ResponseEntity<>(HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/answer/{responseId}")
    public ResponseEntity<String> createAnswerClaim(@PathVariable("responseId") Long responseId,
                                                    @RequestBody SecureClaimEntity secureClaimEntity) {
        if (secureService.checkAuthorization(secureClaimEntity.getSecure())) {
            return claimService.createAnswerClaim(secureClaimEntity.getClaim(), responseId)
                    ? new ResponseEntity<>(HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/answer")
    @ResponseBody
    public Claim getLastAnswer(@RequestBody SecureEntity secureEntity) {
        if (secureService.checkAuthorization(secureEntity)) {
            return claimService.getLastAnswer(secureEntity.getLogin()).orElse(null);
        }
        return null;
    }

    @PostMapping("/answer/view/{claimId}")
    @ResponseBody
    public Claim getAnswer(@PathVariable("claimId") Long claimId,
                           @RequestBody SecureEntity secureEntity) {
        if (secureService.checkAuthorization(secureEntity)) {
            return claimService.getAnswerById(secureEntity.getLogin(), claimId).orElse(null);
        }
        return null;
    }
}
