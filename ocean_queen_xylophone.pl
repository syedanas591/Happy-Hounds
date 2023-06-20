Website

#!/usr/bin/perl

#The first few lines set up the environment variables
use strict;
use warnings;
use CGI;
use CGI::Carp qw(fatalsToBrowser);

#Create a new CGI object
my $cgi = new CGI;

#Print the CGI header
print $cgi->header;

#Open HTML document
print $cgi->start_html( -title => "Happy Hounds" );

#Create content section
print $cgi->h1('Welcome to Happy Hounds!');

#Print the logo image
print $cgi->img({-src => "happydogs.jpg"}, "");

#Set up navigation bar
print $cgi->start_ul({-style => "padding: 10px;"});
print $cgi->li($cgi->a({-href => "index.html"}, "Home"));
print $cgi->li($cgi->a({-href => "boardingservices.html"}, "Boarding Services"));
print $cgi->li($cgi->a({-href => "adoptions.html"}, "Adoptions"));
print $cgi->li($cgi->a({-href => "contact.html"}, "Contact Us"));
print $cgi->end_ul;

#Create an introduction paragraph
print $cgi->p("Happy Hounds is a dedicated dog boarding and adoption center located in the heart of Seattle. We offer a wide range of services for dogs of all shapes and sizes, from overnight boarding to basic puppy training. Our friendly and knowledgeable staff will make sure that your canine companion is happy and healthy while in our care. Please explore our website to learn more about our services and the dogs available for adoption.");

#Set up a form to allow visitors to sign up for more information
print $cgi->start_form(-method => "post", -action => "submit_request.pl");

print $cgi->h3("Sign Up For More Information:");

#Create inputs for name and email
print $cgi->p("Name: ", $cgi->textfield(-name => "name", -size => 30));
print $cgi->p("Email: ", $cgi->textfield(-name => "email", -size => 30));

#Create a submit button
print $cgi->submit(-name => "submit", -value => "Sign Up");

print $cgi->end_form;

#Close HTML document
print $cgi->end_html;