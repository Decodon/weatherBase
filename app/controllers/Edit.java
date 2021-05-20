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

public class Edit extends Controller
{
    public static void index(){
        render ("edit.html");
    }

    public static void editMember(Long id, String firstname, String lastname, String email, String password) {
        Member member = new Member(firstname, lastname, email, password);
        member.save();
        redirect("/dashboard");
    }
}