package com.radu.contacts;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Contact {

    private int id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;


}
