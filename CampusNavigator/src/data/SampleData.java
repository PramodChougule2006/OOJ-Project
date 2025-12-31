package data;

import model.*;

public class SampleData {
    public static CampusMap buildMap() {
        CampusMap map = new CampusMap();

        Location mainGate = new Location("M1", "Main Gate", 25, 25);
        Location aps = new Location("M2", "APS Block", 35, -5);
        Location IH = new Location("H1", "IH Hostel", -20, -15);
        Location kangchenjunga = new Location("H2", "Kangchenjunga Hostel", -20, -25);
        Location scienceBlock = new Location("S1", "Science Block", -20, -5);
        Location playGround = new Location("P1", "Playground", 20, 5);
        Location administration = new Location("A1", "Administration Block", 20, 15);
        Location indoor = new Location("I1", "Indoor Sports Complex", 20, -5);
        Location pj = new Location("P2", "PJ Block", 0, 0);
        Location mart = new Location("M3", "Campus Book Mart", 5, -5);
        Location pg = new Location("P3", "PG Block", 0, 10);
        Location mech = new Location("M4", "Mechanical Block", -20, 25);
        Location hostelGate = new Location("H3", "Hostel Gate", -20, -10);
        Location backGate = new Location("B1", "Back Gate", -20, -30);
        Location mess = new Location("M5", "Hostel Mess", 0, -20);
        Location canteen = new Location("C1", "Canteen", 20, -10);
        Location cafeteria = new Location("C2", "Cafeteria", 5, 15);
        Location architecture = new Location("A2", "Architecture Block", 15, 30);
        Location law = new Location("L1", "Law Block", -5, 30);
        Location hostelOffice = new Location("H4", "Hostel Office", 80, 80);
        Location mph = new Location("M6", "MPH Hall", 5, -15);
        Location canteenRoad = new Location("C3", "Canteen Road", 0, -10);
        Location hostelRoad = new Location("H5", "Hostel Road", -20, -20);
        Location mainRoad = new Location("M6", "Main Road", 35, 25);
        Location innerRoad = new Location("M7", "Inner Road", 0, 25);
        Location mainGateRoad = new Location("M8", "Main GateRoad", 20, 25);
        Location campusbackroad = new Location("M9", "Campus Back Road", -20, 5);

        

        map.addUndirectedPath(mainGate, mainRoad, 30, 0.375, true);
        map.addUndirectedPath(aps, mainRoad, 120, 1.5, true);
        map.addUndirectedPath(mainGate, mainGateRoad, 20, 0.25, true);
        map.addUndirectedPath(administration, mainGateRoad, 30, 0.375, true);
        map.addUndirectedPath(mainGate, pg, 100, 1.25, true);
        map.addUndirectedPath(mainGateRoad, architecture, 40, 0.5, true);
        map.addUndirectedPath(IH, hostelRoad, 20, 0.25, true);
        map.addUndirectedPath(kangchenjunga, hostelRoad, 32, 0.4, true);
        map.addUndirectedPath(hostelGate, hostelRoad, 50, 0.625, true);
        map.addUndirectedPath(pg, pj, 55, 0.6875, true);
        map.addUndirectedPath(pj, scienceBlock, 17, 0.2125, true);
        map.addUndirectedPath(playGround, indoor, 50, 0.625, true);
        map.addUndirectedPath(playGround, pj, 70, 0.875, true);
        map.addUndirectedPath(playGround, pg, 55, 0.6875, true);
        map.addUndirectedPath(innerRoad, law, 45, 0.5625, true);
        map.addUndirectedPath(pj, mech, 125, 1.5625, true);
        map.addUndirectedPath(innerRoad, cafeteria, 37, 0.4625, true);
        map.addUndirectedPath(cafeteria, pg, 30, 0.375, true);
        map.addUndirectedPath(innerRoad, mech, 82, 1.025, true);
        map.addUndirectedPath(mech, scienceBlock, 148, 1.85, true);
        map.addUndirectedPath(pg, campusbackroad, 70, 0.875, true);
        map.addUndirectedPath(scienceBlock, campusbackroad, 73, 0.9125, true);
        map.addUndirectedPath(scienceBlock, hostelGate, 25, 0.3125, true);
        map.addUndirectedPath(mess, mph, 12, 0.15, true);
        map.addUndirectedPath(kangchenjunga, backGate, 25, 0.3125, true);
        map.addUndirectedPath(mess, hostelRoad, 40, 0.5, true);
        map.addUndirectedPath(canteen, indoor, 20, 0.25, true);
        map.addUndirectedPath(pj, mart, 20, 0.25, true);
        map.addUndirectedPath(canteen, canteenRoad, 55, 0.6875, true);
        map.addUndirectedPath(mart, canteenRoad, 30, 0.375, true);
        map.addUndirectedPath(canteenRoad, hostelGate, 72, 0.9, true);
        map.addUndirectedPath(mess, hostelOffice, 10, 0.125, true);
        map.addUndirectedPath(administration, playGround, 60, 0.75, true);
        map.addUndirectedPath(innerRoad, mainGateRoad, 50, 0.625, true);
        map.addUndirectedPath(playGround, campusbackroad, 125, 1.5625, true);
        map.addUndirectedPath(administration, pg, 70, 0.875, true);

        return map;
    }
}