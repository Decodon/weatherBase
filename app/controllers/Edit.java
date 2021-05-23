package controllers;

import models.Reading;
import models.Station;
import play.*;
import play.mvc.*;

import java.util.List;
import java.util.Scanner;

import models.Member;

import play.mvc.Controller;
import utils.StationAnalytics;

public class Edit extends Controller {
    public static void index() {
        render("edit.html");
    }

    public static void editMember(String firstname, String lastname, String email, String password) {
        Member member = null;
        if (session.contains("logged_in_Memberid")) {
            String memberId = session.get("logged_in_Memberid");
            member = Member.findById(Long.parseLong(memberId));
            member.setFirstname(firstname);
            member.setLastname(lastname);
            member.setPassword(password);
            member.setEmail(email);
            member.save();
        }
        redirect("/dashboard");
    }
}