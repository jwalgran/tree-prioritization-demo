#!/bin/bash

echo
echo ----------------- health-check
curl http://localhost:8081/tile/gt/health-check

echo
echo ----------------- breaks
curl -d 'bbox=-13193643.578247702,3977047.2455633273,-13100389.403739786,4039419.8606440313&layers=us-census-property-value-30m-epsg3857&weights=2&numBreaks=10&srid=3857' -X POST "http://localhost:8081/tile/gt/breaks"

echo
echo ----------------- tile
curl -d 'bbox=-13193642.578247702,3977047.2455633273,-13100389.403739786,4039419.8606440313&layers=us-census-property-value-30m-epsg3857&weights=1&numBreaks=10&srid=3857&breaks=9,19,29,39,49,59,69,79,89,99&' -X POST "http://localhost:8081/tile/gt/tile/11/297/388.png" > ~/tile.png
