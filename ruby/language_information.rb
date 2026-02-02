class LanguageInformation
  attr_accessor :name, :family, :country, :speakers
  def initialize(name, family, country, speakers=-1)
    @name = name
    @family = family
    @country = country
    @speakers = speakers
  end
  def print_info
    puts "#{@name} is #{['a','e','i','o','u'].include?(@family.downcase[0]) ? "an" : "a"} #{@family} language spoken #{@speakers >= 0 ? "by #{@speakers} people " : ""}in #{@country}."
  end
end

kawesqar = LanguageInformation.new "Kawésqar", "Alacalufan", "Chile", 10
kawesqar.print_info
kawesqar.speakers=-1
kawesqar.print_info
